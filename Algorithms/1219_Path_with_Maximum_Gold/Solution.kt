import kotlin.math.max

class Solution {
    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    fun getMaximumGold(grid: Array<IntArray>): Int = grid.indices
            .flatMap { i ->
                grid[0].indices
                        .filter { j -> grid[i][j] != 0 }
                        .map { j -> dfs(grid, i, j, grid[i][j]) }
            }.max()!!

    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, acc: Int): Int = grid[x][y].let {
        grid[x][y] = 0
        var maxAcc = acc
        for (i in 0..3) {
            val (ax, ay) = (x + dx[i]) to (y + dy[i])
            if (ax in (grid.indices) && ay in (0 until grid[0].size) && grid[ax][ay] != 0) {
                maxAcc = max(maxAcc, dfs(grid, ax, ay, acc + grid[ax][ay]))
            }
        }
        grid[x][y] = it
        maxAcc
    }
}
