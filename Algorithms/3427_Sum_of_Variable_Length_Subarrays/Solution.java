class Solution {
    public int subarraySum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int start = Math.max(0, i - nums[i]);
            while (start <= i) {
                res += nums[start++];
            }
        }
        return res;
    }
}
