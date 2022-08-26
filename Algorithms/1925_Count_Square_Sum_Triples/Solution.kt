import kotlin.math.sqrt

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-26
 */
class Solution {
    fun countTriples(n: Int): Int {
        var res = 0
        for (i in 1..n) {
            for (j in 1..n) {
                val sum = i * i + j * j
                val k = sqrt(sum.toDouble()).toInt()
                if (k <= n && k * k == sum) {
                    ++res
                }
            }
        }
        return res
    }
}
