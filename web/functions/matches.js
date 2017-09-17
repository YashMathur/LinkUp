const functions = require('firebase-functions');
const admin = require("firebase-admin");

// max distance is 100m
const MAX_D = 100;
const RECRUITER = 'RECRUITER';
const CANDIDATE = 'CANDIDATE';

admin.initializeApp(functions.config().firebase);
const db = admin.database();


// https://stackoverflow.com/a/27943/4647683
function deg2rad(deg) {
  return deg * (Math.PI/180)
}

function getD(
  { mLatitude: lat1, mLongitude: lon1 },
  { mLatitude: lat2, mLongitude: lon2 }
) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1);
  var a =
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
    Math.sin(dLon/2) * Math.sin(dLon/2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  var d = R * c * 1000; // distance in m
  return d;
}

function matchSkill(level) {
  switch (level) {
    case 'HIGH': {
      return 3;
    }

    case 'MEDIUM': {
      return 2;
    }

    case 'LOW': {
      return 1;
    }

    default: {
      return 0;
    }
  }
}

function calculateMatch(recruiter, candidate) {
  const recruiterSkills = Object.keys(recruiter.mSkills);
  const metaScore = recruiterSkills.reduce((memo, skill) => {
    return memo + matchSkill(candidate.mSkills[skill]);
  }, 0);

  const percentage = metaScore / (recruiterSkills.length * 3);
  return percentage.toFixed(2);
}

function updateMatches(req, res) {
  if (req.method !== 'POST') {
    res.status(403).send('Forbidden');
    return;
  }

  const userId = req.body.userId;

  const usersPromise = db.ref('/users').once('value');
  const linksPromise = db.ref('/links').once('value');

  return Promise.all([usersPromise, linksPromise])
    .then(([usersSnap, linksSnap]) => {
      const links = linksSnap.val();
      const user = usersSnap.val()[userId];
      const updatePromises = [];

      usersSnap.forEach((snap) => {
        const otherUser = snap.val()
        const otherUserId = otherUser.mUserId;

        // can't match recruiter with recruiter ;)
        if (user.mType == otherUser.mType) {
          return;
        }

        // dont link same user LOL
        if (userId == otherUserId) {
          return;
        }

        const recruiter = user.mType === RECRUITER ? user : otherUser;
        const candidate = user.mType === CANDIDATE ? user : otherUser;

        const linkHash = `${recruiter.mUserId}+${candidate.mUserId}`;
        const matched = calculateMatch(recruiter, candidate);

        // no duplicate links
        if (links && links[linkHash]) {
          return;
        }

        if (getD(otherUser.mLocation, user.mLocation) <= MAX_D) {
          const createLink = db.ref('/links').update({
            [linkHash]: {
              createdAt: Date.now(),
              recruiter,
              candidate,
              matched
            }
          });

          const pushLinks = [
            db.ref(`/users/${userId}/links`).update({ [linkHash]: true }),
            db.ref(`/users/${otherUserId}/links`).update({ [linkHash]: true })
          ];

          updatePromises.push(createLink);
          updatePromises.push(Promise.all(pushLinks));
        }
      });

      return Promise.all(updatePromises).then(() => {
        res.status(200).send('OK');
      });
    });
}

module.exports = functions.https.onRequest(updateMatches);
