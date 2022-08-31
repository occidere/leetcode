/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-31
 */
class Solution {
    fun findBall(grid: Array<IntArray>) = grid.first()
        .indices
        .map { grid.fall(it) }
        .toIntArray()

    private fun Array<IntArray>.fall(ball: Int): Int {
        val (m, n) = size to first().size
        var (x, y) = 0 to ball
        var pos = ball
        while (x < m) {
            val cur = this[x][y]
            if (cur == 1 && y < n - 1 && this[x][y + 1] == 1) {
                ++y
                ++pos
            } else if (cur == -1 && 0 < y && this[x][y - 1] == -1) {
                --y
                --pos
            } else {
                return -1
            }
            ++x
        }
        return pos
    }
}
