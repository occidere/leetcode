class Solution {
    private lateinit var obs: Set<Pair<Int, Int>>

    private var di = 0
    private val dx = intArrayOf(0, -1, 0, 1)
    private val dy = intArrayOf(1, 0, -1, 0)
    private val turnLeft: () -> Pair<Int, Int> = {
        di = (di + 1).rem(4)
        dx[di] to dy[di]
    }
    private val turnRight: () -> Pair<Int, Int> = {
        di = (di + 3).rem(4)
        dx[di] to dy[di]
    }

    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        obs = obstacles.map { it[0] to it[1] }.toSet()

        var furthest = 0
        var cur = 0 to 0
        for (cmd in commands) {
            when (cmd) {
                -1 -> turnRight()
                -2 -> turnLeft()
                else -> {
                    cur = cur.getPositionAfterMove(cmd)
                    furthest = kotlin.math.max(furthest, cur.first * cur.first + cur.second * cur.second)
                }
            }
        }
        return furthest
    }

    private fun Pair<Int, Int>.getPositionAfterMove(d: Int): Pair<Int, Int> {
        var cur = this
        repeat(d) {
            val next = cur.first + dx[di] to cur.second + dy[di]
            if (obs.contains(next)) {
                return cur
            } else {
                cur = next
            }
        }
        return cur
    }
}
