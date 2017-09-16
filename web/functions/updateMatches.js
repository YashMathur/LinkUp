const functions = require('firebase-functions');

// max distance is 1km
const MAX_D = 1

// https://stackoverflow.com/a/27943/4647683
function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1);
  var a =
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
    Math.sin(dLon/2) * Math.sin(dLon/2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  var d = R * c; // Distance in km
  return d;
}

function deg2rad(deg) {
  return deg * (Math.PI/180)
}

function updateMatches(event) {
  console.log(event);
  console.log(event.data.exists());
  console.log(event.data.val());
  const { mLatitude, mLongitude } = event.data.val();
  return event.data.ref('value')
    .then(snapshot => {
      console.log(snapshot);
    });
}

module.exports = functions
  .database
  .ref('/users/{userId}/mLocation')
  .onWrite(updateMatches);
