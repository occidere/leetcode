class Solution {
    public int minMoves(int[] nums) {
        int maxVal = Arrays.stream(nums).max().orElse(0);
        return Arrays.stream(nums)
            .map(x -> maxVal - x)
            .sum();
    }
}
