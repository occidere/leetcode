/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-01
 */
class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        var cnt = 0
        for (i in grid.indices) {
            val rows = grid[i].toList()
            for (j in grid.indices) {
                val cols = grid.indices.map { k -> grid[k][j] }
                if (rows == cols) {
                    ++cnt
                }
            }
        }
        return cnt
    }
}
