/**
 * @param {number[]} arr
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
const countGoodTriplets = function (arr, a, b, c) {
  let ans = 0;
  const n = arr.length;
  for (let i = 0; i < n - 2; ++i) {
    for (let j = i + 1; j < n - 1; ++j) {
      for (let k = j + 1; k < n; ++k) {
        const [x, y, z] = [Math.abs(arr[i] - arr[j]), Math.abs(arr[j] - arr[k]), Math.abs(arr[k] - arr[i])];
        if (x <= a && y <= b && z <= c) {
          ++ans;
        }
      }
    }
  }
  return ans;
};
