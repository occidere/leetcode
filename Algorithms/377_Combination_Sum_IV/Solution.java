import java.util.*;

class Solution {

    /*
    Approach: Top-Down 방식으로 target 값을 차감하면서 dp 에 경우의 수를 기록

    Time Complexity: O(T * N). T = target 값, N = nums 의 크기
    Space Complexity: O(T)
    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(nums, dp, target);
    }

    private int dfs(int[] nums, int[] dp, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int sum = 0;
        for (int n : nums) {
            if (target >= n) {
                sum += dfs(nums, dp, target - n);
            }
        }
        return dp[target] = sum;
    }
}
