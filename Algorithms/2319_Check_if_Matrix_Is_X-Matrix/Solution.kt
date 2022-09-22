/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-22
 */
class Solution {
    fun checkXMatrix(grid: Array<IntArray>): Boolean {
        var (i, j) = 0 to 0
        while (i < grid.size && j < grid.size) {
            if (grid[i][j] == 0) {
                return false
            }
            grid[i++][j++] = 0
        }
        i = 0
        --j
        while (i < grid.size && -1 < j) {
            if (i != j && grid[i][j] == 0) {
                return false
            }
            grid[i++][j--] = 0
        }
        return grid.all { xs -> xs.all { it == 0 } }
    }
}
