class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}