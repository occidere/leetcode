/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-07-24
 */
class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val (m, n) = maze.size to maze[0].size
        val board = Array(m) { IntArray(n) { 0 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (maze[i][j] == '+') {
                    board[i][j] = -1
                }
            }
        }
        board[entrance[0]][entrance[1]] = 1

        var minPath = 0x3f3f3f3f
        val q = mutableListOf(entrance)
        val ds = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            for ((dx, dy) in ds) {
                val (ax, ay) = x + dx to y + dy
                if (ax in 0 until m && ay in 0 until n) {
                    if ((board[ax][ay] == 0 || board[x][y] + 1 < board[ax][ay])) {
                        board[ax][ay] = board[x][y] + 1
                        q.add(intArrayOf(ax, ay))
                    }
                } else if (x != entrance[0] || y != entrance[1]) {
                    minPath = kotlin.math.min(minPath, board[x][y])
                }
            }
        }
        return if (minPath == 0x3f3f3f3f) -1 else minPath - 1
    }
}
