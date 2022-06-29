import java.util.*
import kotlin.math.min

class Solution {
    fun largestValsFromLabels(values: IntArray, labels: IntArray, numWanted: Int, useLimit: Int) = values.zip(labels)
        .groupBy({ it.second }) { it.first }
        .values
        .map {
            it.sortedDescending()
                .take(min(it.size, useLimit))
                .toMutableList()
        }.let {
            PriorityQueue<MutableList<Int>>(Comparator { xs, ys -> ys[0] - xs[0] })
                .apply {
                    addAll(it)
                }
        }.let { pq ->
            var (acc, left) = 0 to numWanted
            while (pq.isNotEmpty() && --left >= 0) {
                val top = pq.poll()
                acc += top.first()
                if (top.size > 1) {
                    top.removeAt(0)
                    pq.add(top)
                }
            }
            acc
        }
}
