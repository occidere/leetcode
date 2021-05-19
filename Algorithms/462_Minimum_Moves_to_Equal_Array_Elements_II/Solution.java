import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
      Arrays.sort(nums);
      int median = nums[nums.length >> 1];
      return Arrays.stream(nums).map(x -> Math.abs(x - median)).sum();
    }
}
