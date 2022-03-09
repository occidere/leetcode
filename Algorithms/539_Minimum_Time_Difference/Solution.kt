class Solution {
    fun findMinDifference(timePoints: List<String>) = timePoints.sorted()
        .let { it + it.first() }
        .zipWithNext()
        .map {
            val (x, y) = it
            if (x <= y) {
                y.toMinutes() - x.toMinutes()
            } else {
                "${y.substring(0, 2).toInt() + 24}:${y.substring(3)}".toMinutes() - x.toMinutes()
            }
        }.min()!!

    private fun String.toMinutes() = split(":").run { first().toInt() * 60 + last().toInt() }
}
