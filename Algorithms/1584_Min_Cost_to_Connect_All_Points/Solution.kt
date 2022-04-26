import kotlin.math.abs

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        // (nodeId, x, y)
        val nodes = points.indices
            .map { Triple(it, points[it][0], points[it][1]) }
            .toTypedArray()
        // (node1Id, node2Id, cost)
        val edges = nodes.indices
            .flatMap { i ->
                (i + 1).until(nodes.size)
                    .map { j ->
                        val (n1, n2) = nodes[i] to nodes[j]
                        Triple(n1.first, n2.first, abs(n2.second - n1.second) + abs(n2.third - n1.third))
                    }
            }.sortedWith(Comparator { e1, e2 -> e1.third - e2.third })

        val disjointSet = IntArray(nodes.size) { -1 }
        var (connected, totalCost) = 0 to 0
        for ((node1, node2, cost) in edges) {
            if (connected >= nodes.size - 1) {
                break
            } else if (disjointSet.union(node1, node2)) {
                ++connected
                totalCost += cost
            }
        }

        return totalCost
    }

    private fun IntArray.findRoot(id: Int): Int = if (this[id] == -1) id else findRoot(this[id])

    private fun IntArray.union(node1: Int, node2: Int) =
        (findRoot(node1) to findRoot(node2)).let {
            if (it.first == it.second) false else {
                this[it.second] = it.first
                true
            }
        }
}
