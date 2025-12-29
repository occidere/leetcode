class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (i == String.valueOf(nums[i]).chars().map(c -> c - 48).sum()) {
                return i;
            }
        }
        return -1;
    }
}
