const functions = require('firebase-functions');

function initMatches(event) {
  const original = event.data.val();
  console.warn(original);
  return;
}

module.exports = functions
  .database
  .ref('/users/{userId}')
  .onCreate(initMatches);
