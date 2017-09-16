const functions = require('firebase-functions');

function initMatches(event) {
  const userId = event.data.val().mUserId;
  return event.data.ref.parent.child('matches').set({
    [userId]: {}
  });
}

module.exports = functions
  .database
  .ref('/users/{userId}')
  .onCreate(initMatches);
