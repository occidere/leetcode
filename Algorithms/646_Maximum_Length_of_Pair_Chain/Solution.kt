/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-11
 */
class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith(Comparator { xs, ys -> if (xs[1] - xs[0] == ys[1] - ys[0]) xs[1] - ys[1] else xs[0] - ys[0] })

        val dp = IntArray(pairs.size) { 1 }
        for (i in 0 until pairs.size - 1) {
            for (j in i + 1 until pairs.size) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[j] = kotlin.math.max(dp[j], dp[i] + 1)
                }
            }
        }

        return dp.last()
    }
}
