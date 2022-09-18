import java.util.*

/**
 * Ref: https://leetcode.com/problems/sequentially-ordinal-rank-tracker/discuss/1632156/Two-Heaps
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-18
 */
class SORTracker {

    private val minHeap =
        PriorityQueue<Pair<String, Int>> { xs, ys -> if (xs.second == ys.second) ys.first.compareTo(xs.first) else xs.second - ys.second }
    private val maxHeap =
        PriorityQueue<Pair<String, Int>> { xs, ys -> if (xs.second == ys.second) xs.first.compareTo(ys.first) else ys.second - xs.second }

    fun add(name: String, score: Int) {
        minHeap.add(name to score)
        maxHeap.add(minHeap.poll())
    }

    fun get() = maxHeap.poll()
        .let {
            minHeap.add(it)
            it.first
        }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * var obj = SORTracker()
 * obj.add(name,score)
 * var param_2 = obj.get()
 */
