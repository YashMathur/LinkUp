const functions = require('firebase-functions');
const admin = require("firebase-admin");

// max distance is 100m
const MAX_D = 100;
const RECRUITOR = 'RECRUITOR';
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

function calculateMatch() {
  return 69;
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

        // can't match recruitor with recruitor ;)
        if (user.mType == otherUser.mType) {
          return;
        }

        // dont link same user LOL
        if (userId == otherUserId) {
          return;
        }

        const recruitor = user.mType === RECRUITOR ? user : otherUser;
        const candidate = user.mType === CANDIDATE ? user : otherUser;

        const linkHash = `${recruitor.mUserId}+${candidate.mUserId}`;
        const matched = calculateMatch(recruitor, candidate);

        // no duplicate links
        if (links && links[linkHash]) {
          return;
        }

        if (getD(otherUser.mLocation, user.mLocation) <= MAX_D) {
          const createLink = db.ref('/links').set({
            [linkHash]: {
              createdAt: Date.now(),
              recruitor,
              candidate
            }
          });

          const pushLinks = [
            db.ref(`/users/${userId}/links`).set({ [linkHash]: true }),
            db.ref(`/users/${otherUserId}/links`).set({ [linkHash]: true })
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
