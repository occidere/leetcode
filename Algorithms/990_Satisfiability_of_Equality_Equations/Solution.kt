/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-26
 */
class Solution {
    fun equationsPossible(equations: Array<String>): Boolean {
        val (eq1, eq2) = equations.groupBy({ "${it[1]}${it[2]}" }) { Pair(it[0] - 'a', it[3] - 'a') }
            .let { it.getOrDefault("==", listOf()) to it.getOrDefault("!=", listOf()) }
        val disjointSet = IntArray(26) { -1 }
        for ((x, y) in eq1) {
            disjointSet.union(x, y)
        }
        for ((x, y) in eq2) {
            if (disjointSet.findRoot(x) == disjointSet.findRoot(y)) {
                return false
            }
        }
        return true
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
