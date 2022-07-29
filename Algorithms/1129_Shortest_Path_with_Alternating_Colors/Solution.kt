/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-29
 */
class Solution {
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val costs = Array(2) { IntArray(n) { -1 } }.also {
            it[0][0] = 0 // 0: red
            it[1][0] = 0 // 1: blue
        }
        val edgesByColor = listOf(-1 to redEdges, 1 to blueEdges)
            .associate { (color, edges) -> color to edges.map { it[0] to it[1] }.groupBy({ it.first }, { it.second }) }

        val q = mutableListOf(Triple(0, 0, -1), Triple(0, 0, 1)) // RED: -1, BLUE: 1
        while (q.isNotEmpty()) {
            val (curNode, cost, prevColor) = q.removeAt(0)
            edgesByColor.getOrDefault(-prevColor, emptyMap())
                .getOrDefault(curNode, listOf())
                .forEach { nextNode ->
                    val nextColorIdx = (2 - prevColor).shr(1)
                    if (costs[nextColorIdx][nextNode] == -1) {
                        costs[nextColorIdx][nextNode] = cost + 1
                        q.add(Triple(nextNode, cost + 1, -prevColor))
                    }
                }
        }

        return 0.until(n).map {
            if (costs[0][it] == -1 || costs[1][it] == -1) {
                kotlin.math.max(costs[0][it], costs[1][it])
            } else {
                kotlin.math.min(costs[0][it], costs[1][it])
            }
        }.toIntArray()
    }
}
