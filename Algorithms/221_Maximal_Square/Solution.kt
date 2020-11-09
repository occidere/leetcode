import kotlin.math.max

class Solution {
    fun maximalSquare(matrix: Array<CharArray>) = if (matrix.isEmpty()) 0 else {
        var maxSize = 0
        val m = matrix.size
        val n = matrix[0].size

        val isInRange = { x: Int, y: Int -> x in 0.until(m) && y in 0.until(n) }
        fun canMove(initX: Int, initY: Int, nextX: Int, nextY: Int): Boolean {
            if (!isInRange(nextX, nextY)) {
                return false
            }

            for (i in initX until nextX) {
                if (matrix[i][nextY] == '0') {
                    return false
                }
            }
            for (i in initY until nextY) {
                if (matrix[nextX][i] == '0') {
                    return false
                }
            }
            return matrix[nextX][nextY] == '1'
        }

        fun calc(initX: Int, initY: Int, x: Int, y: Int, len: Int = 1): Int =
                if (canMove(initX, initY, x + 1, y + 1)) calc(initX, initY, x + 1, y + 1, len + 1) else len * len

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '1') {
                    maxSize = max(maxSize, calc(i, j, i, j))
                }
            }
        }

        maxSize
    }
}