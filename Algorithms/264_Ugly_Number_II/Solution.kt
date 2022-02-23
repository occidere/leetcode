import kotlin.math.min

class Solution {
    /**
     * Optimal solution using DP
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    fun nthUglyNumber(n: Int): Int {
        val arr = IntArray(n) { 1 }
        var (idx2, idx3, idx5) = Triple(0, 0, 0)
        for (i in 1 until n) {
            arr[i] = min(min(2 * arr[idx2], 3 * arr[idx3]), 5 * arr[idx5]).also { ugly ->
                if (ugly == 2 * arr[idx2]) ++idx2
                if (ugly == 3 * arr[idx3]) ++idx3
                if (ugly == 5 * arr[idx5]) ++idx5
            }
        }
        return arr.last()
    }

    /**
     * My initial approach using Min Heap
     *
     * Time Complexity: O(NlogN)
     * Space Complexity: O(N)
     */
//    fun nthUglyNumber(n: Int): Int {
//        val pq = java.util.PriorityQueue<Long>().apply { offer(1) }
//        val visit = mutableSetOf(1L)
//        val primeFactors = listOf(2, 3, 5)
//
//        for (i in 1 until n) {
//            val ugly = pq.poll()
//            primeFactors.map { it * ugly }
//                .filterNot { visit.contains(it) }
//                .forEach { visit += it; pq.offer(it) }
//        }
//
//        return pq.poll().toInt()
//    }
}
