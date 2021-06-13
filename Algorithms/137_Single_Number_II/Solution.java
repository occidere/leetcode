class Solution {
    // https://leetcode.com/problems/single-number-ii/solution/
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for (int n : nums) {
            once = ~twice & (once ^ n);
            twice = ~once & (twice ^ n);
        }
        return once;
    }
}
