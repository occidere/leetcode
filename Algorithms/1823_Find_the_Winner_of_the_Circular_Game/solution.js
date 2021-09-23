/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
const findTheWinner = function (n, k) {
  let friends = [];
  for (let i = 1; i <= n; ++i) {
    friends.push(i);
  }
  let pos = 0;
  while (friends.length > 1) {
    pos = (pos + k - 1) % friends.length;
    friends.splice(pos, 1);
  }
  return friends[0];
};
