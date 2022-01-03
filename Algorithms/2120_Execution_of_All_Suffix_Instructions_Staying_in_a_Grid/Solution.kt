class Solution {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        fun String.getMovedCount(): Int {
            var (curPos, acc) = intArrayOf(startPos[0], startPos[1]) to 0
            for (c in this) {
                val d: IntArray = when (c) {
                    'U' -> intArrayOf(-1, 0)
                    'D' -> intArrayOf(1, 0)
                    'L' -> intArrayOf(0, -1)
                    else -> intArrayOf(0, 1)
                }
                curPos = intArrayOf(curPos[0] + d[0], curPos[1] + d[1])
                if (curPos[0] in 0 until n && curPos[1] in 0 until n) {
                    ++acc
                } else {
                    break
                }
            }
            return acc
        }
        return s.indices
            .map { s.drop(it).getMovedCount() }
            .toIntArray()
    }
}
