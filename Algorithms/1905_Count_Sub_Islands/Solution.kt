class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        grid1.overlapTo(grid2)
        return grid2.getSubIslandCount()
    }

    private fun Array<IntArray>.overlapTo(grid: Array<IntArray>) {
        for (i in indices) {
            for (j in this[0].indices) {
                if (this[i][j] == 1 && grid[i][j] == 1) {
                    ++grid[i][j]
                }
            }
        }
    }

    private fun Array<IntArray>.getSubIslandCount(): Int {
        var cnt = 0

        for (i in indices) {
            for (j in this.indices) {
                if (this[i][j] == 2) {
                    if (Pair(i, j).isSubIslandPartOf(this)) {
                        ++cnt
                    }
                }
            }
        }

        return cnt
    }

    private fun Pair<Int, Int>.isSubIslandPartOf(grid: Array<IntArray>): Boolean {
        grid[first][second] = 0

        var isSubIsland = true
        val d = intArrayOf(-1, 1, 0, 0) to intArrayOf(0, 0, -1, 1)
        val q = mutableListOf(this)
        while (q.isNotEmpty()) {
            val cur = q.removeAt(0)
            for (i in 0 until 4) {
                val next = Pair(cur.first + d.first[i], cur.second + d.second[i])
                if (next.isInsideOf(grid)) {
                    when (grid[next.first][next.second]) {
                        2 -> {
                            q += next
                            grid[next.first][next.second] = 0
                        }
                        1 -> isSubIsland = false
                        else -> Unit // case 0
                    }
                }
            }
        }

        return isSubIsland
    }

    private fun Pair<Int, Int>.isInsideOf(grid: Array<IntArray>) = first in grid.indices && second in grid[0].indices
}
