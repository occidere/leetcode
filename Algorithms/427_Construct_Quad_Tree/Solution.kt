/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */
class Solution {
    fun construct(
        grid: Array<IntArray>,
        topLeftPos: Pair<Int, Int> = Pair(0, 0),
        botRightPos: Pair<Int, Int> = Pair(grid.size - 1, grid[0].size - 1)
    ): Node {
        val acc = grid.getSum(topLeftPos, botRightPos)
        val node = Node(acc > 0, acc.isLeafSum(topLeftPos, botRightPos))

        if (!node.isLeaf) {
            val nextPos = getQuadPairsOf(topLeftPos, botRightPos)
            node.topLeft = construct(grid, nextPos[0].first, nextPos[0].second)
            node.topRight = construct(grid, nextPos[1].first, nextPos[1].second)
            node.bottomLeft = construct(grid, nextPos[2].first, nextPos[2].second)
            node.bottomRight = construct(grid, nextPos[3].first, nextPos[3].second)
        }

        return node
    }

    private fun Array<IntArray>.getSum(topLeftPos: Pair<Int, Int>, botRightPos: Pair<Int, Int>) =
        (topLeftPos.first..botRightPos.first).flatMap { i ->
            (topLeftPos.second..botRightPos.second).map { j -> this[i][j] }
        }.sum()

    private fun Int.isLeafSum(topLeftPos: Pair<Int, Int>, botRightPos: Pair<Int, Int>) =
        this == 0 || this == (botRightPos.first - topLeftPos.first + 1) * (botRightPos.second - topLeftPos.second + 1)

    private fun getQuadPairsOf(topLeftPos: Pair<Int, Int>, botRightPos: Pair<Int, Int>): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        val (midX, midY) = Pair(
            topLeftPos.first + (botRightPos.first - topLeftPos.first).shr(1),
            topLeftPos.second + (botRightPos.second - topLeftPos.second).shr(1)
        )
        return listOf(
            topLeftPos to (midX to midY), // topLeft
            (topLeftPos.first to midY + 1) to (midX to botRightPos.second), // topRight
            (midX + 1 to topLeftPos.second) to (botRightPos.first to midY), // botLeft
            (midX + 1 to midY + 1) to botRightPos // botRight
        )
    }
}
