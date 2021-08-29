class Solution {
    fun regionsBySlashes(grid: Array<String>): Int {
        val board = Array(grid.size * 3) { IntArray(grid.size * 3) { 0 } }
        for (i in grid.indices) {
            for (j in grid.indices) {
                if (grid[i][j] != ' ') {
                    val shape =
                        if (grid[i][j] == '/') arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 1, 0), intArrayOf(1, 0, 0))
                        else arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))
                    val (x, y) = Pair(i * 3, j * 3)
                    for (a in 0 until 3) {
                        for (b in 0 until 3) {
                            board[a + x][b + y] = shape[a][b]
                        }
                    }
                }
            }
        }

        var regions = 0
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 0) {
                    ++regions
                    board.bfs(i to j)
                }
            }
        }
        return regions
    }

    private fun Array<IntArray>.bfs(pos: Pair<Int, Int>) {
        val q = mutableListOf(pos)
        this[pos.first][pos.second] = 1
        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1).forEach {
                val (ax, ay) = x + it.first to y + it.second
                if (ax in this.indices && ay in this.indices && this[ax][ay] == 0) {
                    q += ax to ay
                    this[ax][ay] = 1
                }
            }
        }
    }
}
