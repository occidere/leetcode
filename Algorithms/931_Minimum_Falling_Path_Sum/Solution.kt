/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-08-25
 */
class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        for (i in 1 until matrix.size) {
            for (j in matrix.indices) {
                matrix[i][j] += listOf(
                    if (0 < j) matrix[i - 1][j - 1] else 0x3f3f3f3f,
                    matrix[i - 1][j],
                    if (j < matrix.size - 1) matrix[i - 1][j + 1] else 0x3f3f3f3f
                ).min()!!
            }
        }
        return matrix.last().min()!!
    }
}
