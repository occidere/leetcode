class Solution {
    private val d = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1) to intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        when (board[click[0]][click[1]]) {
            'M' -> board[click[0]][click[1]] = 'X'
            else -> board.unRevealEmptyMatrix(click) // only E
        }
        return board
    }

    private fun Array<CharArray>.unRevealEmptyMatrix(click: IntArray) {
        replaceEmptyMatrixAt(click[0], click[1])
        val q = mutableListOf(click[0] to click[1])
        val visit = Array(size) { BooleanArray(first().size) { false } }

        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0).apply { visit[first][second] = true }
            if (this[x][y] == 'B') {
                0.until(8).forEach { i ->
                    val (ax, ay) = x + d.first[i] to y + d.second[i]
                    if (Pair(ax, ay).isValidCoordinateOf(this) && !visit[ax][ay] && this[ax][ay] == 'E') {
                        replaceEmptyMatrixAt(ax, ay)
                        if (this[ax][ay] == 'B') {
                            q += ax to ay
                        }
                    }
                }
            }
        }
    }

    private fun Array<CharArray>.replaceEmptyMatrixAt(x: Int, y: Int) {
        this[x][y] = findAdjacentMines(x, y).let { if (it == 0) 'B' else (it + 48).toChar() }
    }

    private fun Array<CharArray>.findAdjacentMines(x: Int, y: Int) = d.first.zip(d.second)
        .map { x + it.first to y + it.second }
        .filter { Pair(it.first, it.second).isValidCoordinateOf(this) }
        .count { this[it.first][it.second] == 'M' }

    private fun Pair<Int, Int>.isValidCoordinateOf(matrix: Array<CharArray>) =
        first in matrix.indices && second in matrix[0].indices
}
