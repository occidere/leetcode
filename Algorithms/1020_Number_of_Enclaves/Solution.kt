/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-20
 */
class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {
        val q = (grid.getBorderLands(true) + grid.getBorderLands(false))
            .distinct()
            .toMutableList()
        val ds = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            if (grid[x][y] != 0) {
                grid[x][y] = 0
                for ((dx, dy) in ds) {
                    val (ax, ay) = x + dx to y + dy
                    if (ax in grid.indices && ay in grid.first().indices && grid[ax][ay] == 1) {
                        q.add(ax to ay)
                    }
                }
            }
        }
        return grid.sumBy { arr -> arr.count { it == 1 } }
    }

    private fun Array<IntArray>.getBorderLands(isRow: Boolean) = 0.until(if (isRow) first().size else size)
        .flatMap { if (isRow) listOf(0 to it, size - 1 to it) else listOf(it to 0, it to first().size - 1) }
        .filter { this[it.first][it.second] == 1 }
        .asSequence()
}
