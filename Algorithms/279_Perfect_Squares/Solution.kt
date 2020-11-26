import kotlin.math.ceil
import kotlin.math.sqrt

class Solution {
    private val dp = mutableMapOf(0 to 0, 1 to 1)
    fun numSquares(n: Int): Int = dp.getOrElse(n, {
        dp[n] = ceil(sqrt(n.toDouble())).toInt().downTo(1).map {
            val sqr = it * it
            when {
                sqr > n -> 0x3f3f3f3f
                sqr == n -> 1
                else -> numSquares(sqr) + numSquares(n - sqr)
            }
        }.min()!!
        dp[n]!!
    })
}