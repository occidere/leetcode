import java.util.stream.IntStream;

class Solution {
    public int alternatingSum(int[] nums) {
        return IntStream.range(0, nums.length)
                .map(i -> i % 2 == 0 ? nums[i] : -nums[i])
                .sum();
    }
}
