class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        double res = 0x3f3f3f3f;
        for (int i = 0; i < n; ++i) {
            res = Math.min(res, (nums[i] + nums[nums.length - i - 1]) / 2.0);
        }
        return res;
    }
}
