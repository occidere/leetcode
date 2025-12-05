class Solution {
    public int countPartitions(int[] nums) {
        int res = 0, n = nums.length - 1;
        int leftSum = 0;
        int rightSum = IntStream.of(nums).sum();
        for (int i = 0; i < n; ++i) {
            leftSum += nums[i];
            rightSum -= nums[i];
            res += (leftSum - rightSum) % 2 == 0 ? 1 : 0;
        }
        return res;
    }
}
