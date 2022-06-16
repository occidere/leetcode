class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val board = Array(m) { IntArray(n) { 0 } }
        walls.forEach { board[it[0]][it[1]] = -1 }
        guards.forEach { board[it[0]][it[1]] = -2 }

        val ds = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        var unguarded = m * n - guards.size - walls.size
        for (g in guards) {
            board[g[0]][g[1]] = -2
            unguarded -= ds.map { board.doGuard(g, it) }.sum()
        }
        return unguarded
    }

    private fun Array<IntArray>.doGuard(xy: IntArray, ds: IntArray): Int {
        var (guarded, pos) = 0 to intArrayOf(xy[0] + ds[0], xy[1] + ds[1])
        while (pos.isInRangeOf(this) && this[pos[0]][pos[1]] >= 0) {
            if (this[pos[0]][pos[1]] != 1) {
                ++guarded
            }
            this[pos[0]][pos[1]] = 1
            pos[0] += ds[0]
            pos[1] += ds[1]
        }
        return guarded
    }

    private fun IntArray.isInRangeOf(board: Array<IntArray>) = this[0] in board.indices && this[1] in board[0].indices
}
