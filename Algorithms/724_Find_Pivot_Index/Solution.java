import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int lefts = 0, rights = Arrays.stream(nums).sum() - nums[0], n = nums.length - 1;
        for (int i = 0; i < n; ++i) {
            if (lefts == rights) {
                return i;
            }
            lefts += nums[i];
            rights -= nums[i + 1];
        }
        return lefts == rights ? n : -1;
    }
}
