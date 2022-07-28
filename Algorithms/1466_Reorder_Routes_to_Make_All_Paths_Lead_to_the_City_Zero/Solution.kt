/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-28
 */
class Solution {
    private lateinit var parents: Map<Int, Set<Int>>
    private lateinit var biDirectedConnections: Map<Int, List<Int>>

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        parents = connections.groupBy({ it[1] }, { it[0] })
            .mapValues { it.value.toSet() }
        biDirectedConnections = connections.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
            .groupBy({ it.first }, { it.second })
        return dfs(0, mutableSetOf(0))
    }

    private fun dfs(cur: Int, visited: MutableSet<Int>): Int {
        var changed = 0
        for (next in biDirectedConnections[cur]!!) {
            if (!visited.contains(next)) {
                visited.add(next)
                changed += (if (cur.isParentOf(next)) 1 else 0) + dfs(next, visited)
                visited.remove(next)
            }
        }
        return changed
    }

    private fun Int.isParentOf(child: Int) = parents[child]?.contains(this) ?: false
}
