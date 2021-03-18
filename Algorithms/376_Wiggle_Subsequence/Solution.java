class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int prevDiff = nums[1] - nums[0];
        int count = nums[0] != nums[1] ? 2 : 1;
        for (int i = 2; i < nums.length; ++i) {
            int curDiff = nums[i] - nums[i - 1];
            if ((prevDiff <= 0 && curDiff > 0) || (prevDiff >= 0 && curDiff < 0)) {
                ++count;
                prevDiff = curDiff;
            }
        }
        return count;
    }
}
