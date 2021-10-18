/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
const sumBase = (n, k) => {
  let converted = '';
  while (n > 0) {
    converted = (n % k) + converted;
    n = Math.floor(n / k);
  }
  return converted.split('')
    .map(x => Number.parseInt(x))
    .reduce((a, b) => a + b, 0);
};
