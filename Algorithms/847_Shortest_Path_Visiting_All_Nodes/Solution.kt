class Solution {
    /**
     * Ref: https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included
     *
     * Time Complexity: O(2^N * N^2)
     * Space Complexity: O(2^N * N)
     */
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val (q, visited) = (mutableListOf<Triple<Int/*cur*/, Int/*visit*/, Int/*cost*/>>() to mutableSetOf<Pair<Int/*cur*/, Int/*visit*/>>()).apply {
            graph.indices.forEach {
                first += Triple(it, 1.shl(it), 0)
                second += Pair(it, 1.shl(it))
            }
        }
        val finished = { v: Int -> v == (1.shl(graph.size) - 1) }

        while (q.isNotEmpty()) {
            val (cur, visit, cost) = q.removeAt(0)

            if (finished(visit)) {
                return cost
            }

            for (next in graph[cur]) {
                val nextVisit = visit.or(1.shl(next))
                val visitSnapshot = Pair(next, nextVisit)

                if (!visited.contains(visitSnapshot)) {
                    q += Triple(next, nextVisit, cost + 1)
                    visited += visitSnapshot
                }
            }
        }

        return -1
    }
}
