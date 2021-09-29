/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const countKDifference = (nums, k) => {
  let count = 0;
  for (let i = 0; i < nums.length; ++i) {
    for (let j = i + 1; j < nums.length; ++j) {
      count += Math.abs(nums[i] - nums[j]) === k ? 1 : 0;
    }
  }
  return count;
};
