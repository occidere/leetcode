import kotlin.math.max
import kotlin.math.min

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-07
 */
class Solution {
    fun findShortestSubArray(nums: IntArray) = nums.asSequence()
        .withIndex()
        .map { it.value to Triple(it.index, it.index, 1) }
        .groupBy(Pair<Int, Triple<Int, Int, Int>>::first) { it.second }
        .values
        .map { xs ->
            xs.reduce { (accMin, accMax, accFreq), (curMin, curMax, curFreq) ->
                Triple(min(accMin, curMin), max(accMax, curMax), accFreq + curFreq)
            }.let { it.second - it.first + 1 to it.third }
        }.sortedWith(Comparator { xs, ys -> if (xs.second == ys.second) xs.first - ys.first else ys.second - xs.second })
        .first()
        .first
}
