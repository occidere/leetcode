/**
 * @param {number[]} nums
 * @return {number}
 */
const findNumberOfLIS = nums => {
  const dp = new Array(nums.length);
  for (let i = 0; i < nums.length; ++i) {
    dp[i] = [1, 0];
  }
  dp[0][1] = 1;

  let lis = 1;
  for (let i = 1; i < nums.length; ++i) {
    let maxLen = 0;
    for (let j = i - 1; j >= 0; --j) {
      if (nums[i] > nums[j]) {
        maxLen = Math.max(maxLen, dp[j][0]);
      }
    }
    lis = Math.max(lis, dp[i][0] += maxLen);

    for (let j = i - 1; j >= 0; --j) {
      if (nums[i] > nums[j] && dp[i][0] - 1 === dp[j][0]) {
        dp[i][1] += dp[j][1];
      }
    }
    dp[i][1] = dp[i][1] !== 0 ? dp[i][1] : 1;
  }

  return dp.filter(x => x[0] === lis)
    .map(x => x[1])
    .reduce((x, y) => x + y, 0);
}
