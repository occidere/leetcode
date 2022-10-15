/**
 * Ref: https://leetcode.com/problems/string-compression-ii/discuss/757506/Detailed-Explanation-Two-ways-of-DP-from-33-to-100
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-15
 */
class Solution {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val n = s.length
        val dp = Array(n + 1) { IntArray(k + 1) { 0x3f3f3f3f } }
        dp[0] = IntArray(k + 1) { 0 }
        for (i in 1..n) {
            for (j in 0..k) {
                if (0 < j) {
                    dp[i][j] = dp[i - 1][j - 1]
                }
                var (removed, count) = 0 to 0
                for (p in i.downTo(1)) {
                    if (s[p - 1] == s[i - 1]) {
                        ++count
                    } else if (++removed > j) {
                        break
                    }
                    dp[i][j] = kotlin.math.min(dp[i][j], dp[p - 1][j - removed] + count.calcLength())
                }
            }
        }
        return dp[n][k]
    }

    private fun Int.calcLength() = when (this) {
        in 0..1 -> this
        in 2..9 -> 2
        in 10..99 -> 3
        else -> 4
    }
}
