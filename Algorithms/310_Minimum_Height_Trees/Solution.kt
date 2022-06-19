// Ref: https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        return if (n == 1) listOf(0) else {
            val graph = Array<MutableList<Int>>(n) { mutableListOf() }
            edges.forEach { (a, b) ->
                graph[a].add(b)
                graph[b].add(a)
            }
            var (leftLeaves, leaves) = n to graph.indices
                .zip(graph)
                .filter { it.second.size == 1 }
                .map { it.first }
            while (leftLeaves > 2) {
                leftLeaves -= leaves.size
                val newLeaves = mutableListOf<Int>()
                for (i in leaves) {
                    val j = graph[i].removeAt(0)
                    graph[j].remove(i)
                    if (graph[j].size == 1) {
                        newLeaves += j
                    }
                }
                leaves = newLeaves
            }
            leaves
        }
    }
}
