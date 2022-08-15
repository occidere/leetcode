/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-15
 */
class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val res = Array(grid.size - 2) { IntArray(grid.size - 2) { 0 } }
        val (outRange, inRange) = 0.until(grid.size - 2) to 0..2
        for (i in outRange) {
            for (j in outRange) {
                var maxVal = 0
                for (p in inRange) {
                    for (q in inRange) {
                        maxVal = kotlin.math.max(maxVal, grid[i + p][j + q])
                    }
                }
                res[i][j] = maxVal
            }
        }
        return res
    }
}
