class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val maxInRowCoords = mutableListOf<Pair<Int, Int>>()
        for (i in matrix.indices) {
            var (minVal, maxY) = matrix[i][0] to 0
            for (j in matrix[i].indices) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j]
                    maxY = j
                }
            }
            maxInRowCoords += Pair(i, maxY)
        }

        return maxInRowCoords.filter { isMaxInColumns(matrix, it.first, it.second) }
            .map { matrix[it.first][it.second] }
            .let { if (it.size == 1) it else emptyList() }
    }

    private fun isMaxInColumns(matrix: Array<IntArray>, r: Int, c: Int): Boolean {
        val cur = matrix[r][c]
        for (i in matrix.indices) {
            if (cur < matrix[i][c]) {
                return false
            }
        }
        return true
    }
}
