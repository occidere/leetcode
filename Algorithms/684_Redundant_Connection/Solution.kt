/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-23
 */
class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val inDegrees = IntArray(edges.size) { 0 }
        val egs = Array(edges.size) { mutableSetOf<Int>() }
        for (e in edges) {
            val (a, b) = e[0] - 1 to e[1] - 1
            ++inDegrees[a]
            ++inDegrees[b]
            egs[a].add(b)
            egs[b].add(a)
        }

        while (true) {
            val removeTargets = inDegrees.indices.filter { inDegrees[it] == 1 }
            if (removeTargets.isEmpty()) {
                break
            }
            for (removeTarget in removeTargets) {
                --inDegrees[removeTarget]
                for (connectedNode in egs[removeTarget]) {
                    --inDegrees[connectedNode]
                    egs[connectedNode].remove(removeTarget)
                }
                egs[removeTarget].clear()
            }
        }

        val duplicated = inDegrees.indices
            .filter { inDegrees[it] != 0 }
            .map { it + 1 }
            .toSet()
        return edges.last { (a, b) -> duplicated.contains(a) && duplicated.contains(b) }
    }
}
