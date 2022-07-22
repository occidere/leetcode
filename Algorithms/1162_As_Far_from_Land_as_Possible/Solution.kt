/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-22
 */
class Solution {
    private val ds = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun maxDistance(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val sum = grid.sumBy { it.sum() }
        if (sum == 0 || sum == m * n) {
            return -1
        }
        grid.indices
            .flatMap { i -> 0.until(n).map { j -> (i to j) } }
            .filter { grid[it.first][it.second] == 1 }
            .forEach { (x, y) ->
                ds.map { (dx, dy) -> x + dx to y + dy }
                    .filter { grid.contains(it.first, it.second) }
                    .forEach {
                        grid[it.first][it.second] = -1
                        grid.bfs(it)
                    }
            }
        return -grid.flatMap { it.toList() }.min()!!
    }

    private fun Array<IntArray>.bfs(land: Pair<Int, Int>) {
        val q = mutableListOf(land)

        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            for ((dx, dy) in ds) {
                val (ax, ay) = x + dx to y + dy
                if (contains(ax, ay) && (this[ax][ay] == 0 || this[x][y] - 1 > this[ax][ay])) {
                    this[ax][ay] = this[x][y] - 1
                    q.add(ax to ay)
                }
            }
        }
    }

    private fun Array<IntArray>.contains(x: Int, y: Int) = x in indices && y in first().indices
}
