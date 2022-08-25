/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-08-25
 */
class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val (m, n) = matrix.size to matrix[0].size
        for (k in matrix[0].indices) {
            var (i, j) = 0 to k
            val e = matrix[i][j]
            while (i < m && j < n) {
                if (e != matrix[i++][j++]) {
                    return false
                }
            }
        }
        for (k in matrix.indices)  {
            var (i, j) = k to 0
            val e = matrix[i][j]
            while (i < m && j < n) {
                if (e != matrix[i++][j++]) {
                    return false
                }
            }
        }
        return true
    }
}
