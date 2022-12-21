/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-19
 */
class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val path = (0 until n).map { mutableListOf<Int>() }
        for ((x, y) in edges) {
            path[x].add(y)
            path[y].add(x)
        }
        val visit = BooleanArray(n) { false }
        val q = mutableListOf(source)
        while (q.isNotEmpty()) {
            val cur = q.removeAt(0)
            visit[cur] = true
            if (cur == destination) {
                return true
            }
            for (next in path[cur]) {
                if (!visit[next]) {
                    q.add(next)
                }
            }
        }
        return false
    }
}
