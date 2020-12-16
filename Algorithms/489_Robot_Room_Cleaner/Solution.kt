/**
 * // This is the Robot's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     fun move(): Boolean {}
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     fun turnLeft() {}
 *     fun turnRight() {}
 *
 *     // Clean the current cell.
 *     fun clean() {}
 * }
 */

class Solution {
    private val visit = mutableSetOf<Pair<Int, Int>>()
    private val directions = arrayOf(
            intArrayOf(-1, 0), // U
            intArrayOf(0, -1), // L
            intArrayOf(1, 0),  // D
            intArrayOf(0, 1)   // R
    )

    fun cleanRoom(robot: Robot, pos: IntArray = intArrayOf(0, 0), delta: Int = 0) {
        Pair(pos[0], pos[1]).apply {
            if (!visit.contains(this)) {
                visit += this
                robot.clean()

                var newDelta = delta
                fun run() {
                    robot.turnLeft()
                    newDelta = (newDelta + 1) % 4
                    if (robot.move()) {
                        directions[newDelta].also {
                            cleanRoom(robot, intArrayOf(pos[0] + it[0], pos[1] + it[1]), newDelta)
                            robot.getBackToOriginPos()
                        }
                    }
                }

                repeat(4) { run() }
            }
        }
    }

    private fun Robot.getBackToOriginPos() {
        this.turnLeft()
        this.turnLeft()
        this.move()
        this.turnLeft()
        this.turnLeft()
    }
}