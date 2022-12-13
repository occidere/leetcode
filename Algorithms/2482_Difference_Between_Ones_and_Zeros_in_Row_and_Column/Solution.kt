/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-13
 */
class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val (m, n) = grid.size to grid[0].size
        val oneRows = grid.map { it.sum() }
        val oneCols = grid[0].indices.map { j -> grid.indices.sumBy { i -> grid[i][j] } }
        return (0 until m).map { i ->
            (0 until n).map { j ->
                oneRows[i] + oneCols[j] - (m - oneRows[i]) - (n - oneCols[j])
            }.toIntArray()
        }.toTypedArray()
    }
}
