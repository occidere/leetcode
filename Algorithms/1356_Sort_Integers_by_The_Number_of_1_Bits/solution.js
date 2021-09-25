/**
 * @param {number[]} arr
 * @return {number[]}
 */
const sortByBits = function (arr) {
  return arr.sort((x, y) => {
    const numberOfOneBits = (dec) => dec.toString(2)
      .split("")
      .map(c => c - '0')
      .reduce((a, b) => a + b, 0);
    const [a, b] = [numberOfOneBits(x), numberOfOneBits(y)];
    return a === b ? x - y : a - b;
  });
};
