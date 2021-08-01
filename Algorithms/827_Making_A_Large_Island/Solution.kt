import kotlin.math.max

class Solution {
    private val islandSizeById = mutableMapOf(0 to 0)
    private val ds = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    private var maxArea = 0
    private lateinit var grid: Array<IntArray>

    fun largestIsland(grid: Array<IntArray>): Int {
        this.grid = grid
        markEachIslandById()
        findMaxArea()
        return maxArea
    }

    private fun markEachIslandById() {
        var islandId = 0
        for (i in grid.indices) {
            for (j in grid.indices) {
                if (grid[i][j] > 0) {
                    bfs(grid, Pair(i, j), ++islandId)
                }
            }
        }
    }

    private fun bfs(grid: Array<IntArray>, pos: Pair<Int, Int>, islandId: Int) {
        var area = 1
        val q = mutableListOf(pos)
        grid[pos.first][pos.second] = -islandId

        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            for (d in ds) {
                val next = Pair(x + d.first, y + d.second)
                if (next.inRangeOf(grid.indices) && grid[next.first][next.second] > 0) {
                    grid[next.first][next.second] = -islandId
                    ++area
                    q += next
                }
            }
        }

        islandSizeById[islandId] = area
        maxArea = max(maxArea, area)
    }

    private fun findMaxArea() {
        for (i in grid.indices) {
            for (j in grid.indices) {
                if (grid[i][j] == 0) {
                    var (area, addedId) = Pair(1, mutableSetOf<Int>())
                    for (d in ds) {
                        val next = Pair(i + d.first, j + d.second)
                        if (next.inRangeOf(grid.indices)) {
                            grid[next.first][next.second].let {
                                if (!addedId.contains(-it)) {
                                    area += islandSizeById[-it]!!
                                    addedId.add(-it)
                                }
                            }
                        }
                    }
                    maxArea = max(maxArea, area)
                }
            }
        }
    }

    private fun Pair<Int, Int>.inRangeOf(range: IntRange) = first in range && second in range
}
