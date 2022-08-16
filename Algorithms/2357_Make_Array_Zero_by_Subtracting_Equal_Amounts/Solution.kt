/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-16
 */
class Solution {
    fun minimumOperations(nums: IntArray): Int {
        val pq = java.util.PriorityQueue<Int>().apply { addAll(nums.toList()) }
        var cnt = 0
        while (pq.isNotEmpty()) {
            val minVal = pq.poll()
            if (minVal != 0) {
                ++cnt
                val tmp = pq.map { it - minVal }
                pq.clear()
                tmp.forEach { pq.offer(it) }
            }
        }
        return cnt
    }
}
