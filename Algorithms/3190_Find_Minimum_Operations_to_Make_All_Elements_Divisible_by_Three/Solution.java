class Solution {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums)
            .map(this::getMinOps)
            .sum();
    }

    private int getMinOps(int n) {
        for (int i = 0; i < 3; ++i) {
            if ((n + i) % 3 == 0 || (n - i) % 3 == 0) {
                return i;
            }
        }
        return 0;
    }
}
