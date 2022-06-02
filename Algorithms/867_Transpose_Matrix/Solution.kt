class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val (m, n) = matrix.size to matrix[0].size
        val transposed = Array(n) { IntArray(m) { 0 } }

        // flip upside down
        for (i in 0 until m.shr(1)) {
            for (j in 0 until n) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[m - i - 1][j]
                matrix[m - i - 1][j] = tmp
            }
        }

        // flip left to right
        for (i in 0 until n) {
            for (j in (m - 1).downTo(0)) {
                transposed[i][m - 1 - j] = matrix[j][i]
            }
        }

        return transposed
    }
}
