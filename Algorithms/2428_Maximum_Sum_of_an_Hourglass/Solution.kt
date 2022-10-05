/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-0
 */
class Solution {
    fun maxSum(grid: Array<IntArray>): Int {
        var maxVal = -1
        for (i in 0 until grid.size - 2) {
            for (j in 2 until grid[i].size) {
                maxVal = kotlin.math.max(maxVal, grid.getSum(i to j))
            }
        }
        return maxVal
    }

    private fun Array<IntArray>.getSum(upperRight: Pair<Int, Int>): Int {
        return (upperRight.second - 2..upperRight.second)
            .sumBy { j -> this[upperRight.first][j] + this[upperRight.first + 2][j] } +
                this[upperRight.first + 1][upperRight.second - 1]
    }
}
