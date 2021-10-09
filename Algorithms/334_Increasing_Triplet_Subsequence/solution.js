/**
 * Ref: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments./266041
 * @param {number[]} nums
 * @return {boolean}
 */
const increasingTriplet = nums => {
  if (nums !== null && nums.length >= 3) {
    let [first, second] = [nums[0], null];
    for (let i = 1; i < nums.length; ++i) {
      if (nums[i] <= first) {
        first = nums[i];
      } else {
        if (second !== null && second < nums[i]) {
          return true;
        }
        second = nums[i];
      }
    }
  }
  return false;
};
