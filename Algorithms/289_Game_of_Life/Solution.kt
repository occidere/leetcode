import kotlin.math.max
import kotlin.math.min

class Solution {
    fun gameOfLife(board: Array<IntArray>, x: Int = 0, y: Int = 0) {
        if (y < board[0].size) {
            board.getNextStatus(x, y).also {
                if (y < board[0].size - 1) gameOfLife(board, x, y + 1)
                else if (x < board.size - 1) gameOfLife(board, x + 1, 0)
                board[x][y] = it
            }
        }
    }

    private fun Array<IntArray>.getNextStatus(x: Int, y: Int): Int {
        var alive = 0

        for (i in max(0, x - 1)..min(x + 1, this.size - 1)) {
            for (j in max(0, y - 1)..min(y + 1, this[0].size - 1)) {
                if (i != x || j != y) alive += this[i][j]
            }
        }

        return if (this[x][y] == 1) {
            if (alive < 2 || alive > 3) 0 else 1
        } else {
            if (alive == 3) 1 else 0
        }
    }
}