/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-14
 */
class Solution {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        grid.forEach { it.sort() }
        var res = 0
        for (j in grid[0].indices) {
            var maxVal = 0
            for (i in grid.indices) {
                maxVal = kotlin.math.max(maxVal, grid[i][j])
            }
            res += maxVal
        }
        return res
    }
}
