/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-03
 */
class Solution {
    fun minCost(colors: String, neededTime: IntArray) = colors.getTargetRanges()
        .sumBy { xs ->
            xs.map { neededTime[it] }
                .sorted()
                .dropLast(1)
                .sum()
        }

    private fun String.getTargetRanges(): List<List<Int>> {
        var prevChar = first()
        val (tmp, ranges) = mutableListOf(0) to mutableListOf<List<Int>>()
        for (i in 1 until length) {
            if (this[i] != prevChar) {
                if (1 < tmp.size) {
                    ranges.add(tmp.toList())
                }
                prevChar = this[i]
                tmp.clear()
            }
            tmp.add(i)
        }
        if (1 < tmp.size) {
            ranges.add(tmp)
        }
        return ranges
    }
}
