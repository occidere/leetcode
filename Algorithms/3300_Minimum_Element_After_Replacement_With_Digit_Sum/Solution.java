class Solution {
    public int minElement(int[] nums) {
        return Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .mapToInt(x -> x.chars().map(y -> y - 48).sum())
            .min()
            .orElse(0);
    }
}
