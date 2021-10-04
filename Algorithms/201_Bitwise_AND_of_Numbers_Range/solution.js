/**
 * 참고: https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/593317/Simple-3-line-Java-solution-faster-than-100
 */
const rangeBitwiseAnd = (left, right) => {
  while (right > left) {
    right &= (right - 1);
  }
  return left & right;
};
