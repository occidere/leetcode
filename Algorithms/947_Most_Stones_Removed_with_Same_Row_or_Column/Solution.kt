/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-19
 */
class Solution {
    fun removeStones(stones: Array<IntArray>): Int {
        val edges = mutableListOf<Pair<Int, Int>>()
        for (i in stones.indices) {
            val (ax, ay) = stones[i]
            for (j in stones.indices) {
                if (i != j) {
                    val (bx, by) = stones[j]
                    if (ax == bx || ay == by) {
                        edges.add(i to j)
                    }
                }
            }
        }
        val disjointSet = IntArray(stones.size) { -1 }
        for ((aid, bid) in edges) {
            disjointSet.union(aid, bid)
        }
        return disjointSet.filter { -1 < it }
            .groupBy { it }
            .map { it.value.size }
            .sum()
    }

    private fun IntArray.findRoot(node: Int): Int =
        if (this[node] == -1) node else {
            this[node] = findRoot(this[node])
            this[node]
        }

    private fun IntArray.union(node1: Int, node2: Int) =
        (findRoot(node1) to findRoot(node2)).let {
            if (it.first != it.second) {
                this[it.second] = it.first
                true
            } else false
        }
}
