class Solution {
    fun isRobotBounded(instructions: String): Boolean {
        var d = 0
        val pos = intArrayOf(0, 0)
        val delta = arrayOf(
                intArrayOf(0, 1),   // [0] UP
                intArrayOf(1, 0),   // [1] RIGHT
                intArrayOf(0, -1),  // [2] DOWN
                intArrayOf(-1, 0)   // [3] LEFT
        )

        /* UP을 바라본 상태로 1회 수행 후 최종 위치가 원점(0, 0) 이거나, UP 이 아닌 다른곳을 바라보고 있으면 언젠간 원점으로 회귀 */
        return intArrayOf(0, 0) contentEquals instructions.map {
            when (it) {
                'L' -> d = (d + 3) % 4
                'R' -> d = (d + 1) % 4
                'G' -> {
                    pos[0] += delta[d][0]
                    pos[1] += delta[d][1]
                }
            }
            pos
        }.last() || d > 0
    }
}