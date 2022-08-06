import kotlin.math.ceil
import kotlin.math.ln

/**
 * Ref: https://me2.do/FuW36ryf
 * 
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-06
 */
class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int) =
        ceil(ln(buckets.toDouble()) / ln(minutesToTest.toDouble() / minutesToDie + 1)).toInt()
}
