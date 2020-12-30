import kotlin.math.max

class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int =
        IntArray(days.last() + 1) { 0 }.also {
            var k = 0
            for (i in 1..days.last()) {
                it[i] = if (i != days[k]) it[i - 1] else {
                    ++k
                    minOf(
                        it[max(0, i - 1)] + costs[0],
                        it[max(0, i - 7)] + costs[1],
                        it[max(0, i - 30)] + costs[2]
                    )
                }
            }
        }.last()
}