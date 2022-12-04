import kotlin.math.abs

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-04
 */
class Solution {
    fun minimumAverageDifference(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        var (ls, rs) = 0.toLong() to nums.map { it.toLong() }.sum()
        var (minAvgDiffIdx, minAvgDiff) = -1 to Long.MAX_VALUE
        for ((i, n) in nums.withIndex()) {
            ls += n
            rs -= n
            val avgDiff = abs(getAvg(ls, i + 1) - getAvg(rs, nums.size - i - 1))
            if (avgDiff < minAvgDiff) {
                minAvgDiff = avgDiff
                minAvgDiffIdx = i
            }
        }
        return minAvgDiffIdx
    }

    private fun getAvg(acc: Long, size: Int) = if (size == 0) 0 else (acc.toDouble() / size).toLong()
}
