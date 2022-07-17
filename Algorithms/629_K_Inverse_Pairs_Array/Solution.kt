/*
Ref: https://leetcode.com/problems/k-inverse-pairs-array/solution/
Must try again later
 */
class Solution {
    fun kInversePairs(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) { 0 } }
        for (i in 1..n) {
            for (j in 0..k) {
                if (j == 0) {
                    dp[i][j] = 1
                } else {
                    for (p in 0..kotlin.math.min(j, i - 1)) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007
                    }
                }
            }
        }
        return dp[n][k]
    }
}
