import java.util.*

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-19
 */
class Solution {
    fun isPossible(nums: IntArray): Boolean {
        val comparator = { xs: MutableList<Int>, ys: MutableList<Int> -> xs.size - ys.size }
        val lastMap = mutableMapOf<Int, PriorityQueue<MutableList<Int>>>()
            .also { it[nums[0]] = PriorityQueue(comparator).apply { add(mutableListOf(nums[0])) } }
            .withDefault { PriorityQueue(comparator) }

        for (n in nums.drop(1)) {
            val prevPQ = lastMap.getValue(n - 1)
            val prevTop = (prevPQ.poll() ?: mutableListOf()).also { it.add(n) }

            lastMap[n] = lastMap.getValue(n).also { it.add(prevTop) }

            if (prevPQ.isEmpty()) {
                lastMap.remove(n - 1)
            } else {
                lastMap[n - 1] = prevPQ
            }
        }

        return lastMap.values.all { pq -> pq.all { it.size >= 3 } }
    }
}
