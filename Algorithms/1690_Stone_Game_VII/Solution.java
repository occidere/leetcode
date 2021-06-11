import java.util.*;

/*
 * 참고: https://leetcode.com/problems/stone-game-vii/solution/ - Approach 3: Optimised Memoization Approach
 */
class Solution {
    private int n;
    private int[] prefixSum;
    private int[][] dp;

    public int stoneGameVII(int[] stones) {
        n = stones.length;
        prefixSum = new int[n + 1];
        dp = new int[n][n];

        for (int[] d : dp) {
            Arrays.fill(d, 0x3f3f3f3f);
        }

        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        return calc(0, n - 1, stones);
    }

    private int calc(int left, int right, int[] stones) {
            if (left == right) {
                return 0;
            } else if (dp[left][right] != 0x3f3f3f3f) {
                return dp[left][right];
            } else if (left + 1 == right) {
                return Math.max(stones[left], stones[right]);
            }

            int removeFirstScore = prefixSum[right + 1] - prefixSum[left + 1];
            int removeLastScore = prefixSum[right] - prefixSum[left];
            return dp[left][right] = Math.max(
                        removeFirstScore - calc(left + 1, right, stones),
                        removeLastScore - calc(left, right - 1, stones)
                    );
    }
}
// stones = [5,3,1,4,2]
// preSum = [0,5,8,9,13,15]
