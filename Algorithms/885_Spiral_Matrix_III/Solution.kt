/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-14
 */
class Solution {
    private var validTrailCount = 1

    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val trail = mutableSetOf(rStart to cStart)
        val targetValidTrailCount = rows * cols

        var pos = Position(rStart to cStart, -1 to 0)
        while (validTrailCount < targetValidTrailCount) {
            pos = move(pos, rows, cols, trail)
        }

        return trail.filter { it.isWithin(rows, cols) }
            .map { intArrayOf(it.first, it.second) }
            .toTypedArray()
    }

    private fun move(pos: Position, rows: Int, cols: Int, trail: MutableSet<Pair<Int, Int>>): Position {
        val (cur, dir) = pos.cur to pos.dir
        val forward = cur.first + dir.first to cur.second + dir.second

        val rightDir = dir.turnRight()
        val right = cur.first + rightDir.first to cur.second + rightDir.second

        return if (!trail.contains(right)) { // can move right
            trail.add(right)
            if (right.isWithin(rows, cols)) {
                ++validTrailCount
            }
            Position(right, rightDir)
        } else {
            trail.add(forward)
            if (forward.isWithin(rows, cols)) {
                ++validTrailCount
            }
            Position(forward, dir)
        }
    }

    private fun Pair<Int, Int>.turnRight() = when (this) {
        0 to 1 -> 1 to 0
        1 to 0 -> 0 to -1
        0 to -1 -> -1 to 0
        else -> 0 to 1
    }

    private fun Pair<Int, Int>.isWithin(rows: Int, cols: Int) =
        first in 0 until rows && second in 0 until cols

    data class Position(val cur: Pair<Int, Int>, val dir: Pair<Int, Int>)
}
