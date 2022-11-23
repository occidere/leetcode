/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-23
 */
class Solution {

    fun slidingPuzzle(board: Array<IntArray>): Int {
        val (dx, dy) = intArrayOf(-1, 1, 0, 0) to intArrayOf(0, 0, -1, 1)
        val visit = mutableSetOf(board.toOneLineString())
        val q = mutableListOf(board to 0)
        while (q.isNotEmpty()) {
            val (curBoard, curCount) = q.removeAt(0)
            if (curBoard.isFinished()) {
                return curCount
            }
            val (x, y) = (0..1).flatMap { i -> (0..2)
                .map { j -> i to j } }
                .first { (i, j) -> curBoard[i][j] == 0 }
            for (i in 0..3) {
                val (ax, ay) = x + dx[i] to y + dy[i]
                if (ax in 0..1 && ay in 0..2) {
                    val next = curBoard.swapped(x to y, ax to ay)
                    if (!visit.contains(next.toOneLineString())) {
                        visit.add(next.toOneLineString())
                        q.add(next to curCount + 1)
                    }
                }
            }
        }
        return -1
    }

    private fun Array<IntArray>.swapped(posA: Pair<Int, Int>, posB: Pair<Int, Int>): Array<IntArray> {
        val swappedArray = Array(2) { IntArray(3) { 0 } }
        for (i in 0..1) {
            for (j in 0..2) {
                swappedArray[i][j] = this[i][j]
            }
        }
        val tmp = swappedArray[posA.first][posA.second]
        swappedArray[posA.first][posA.second] = swappedArray[posB.first][posB.second]
        swappedArray[posB.first][posB.second] = tmp
        return swappedArray
    }

    private fun Array<IntArray>.isFinished() = toOneLineString() == "1_2_3_4_5_0"

    private fun Array<IntArray>.toOneLineString() = flatMap { it.toList() }.joinToString("_")
}
