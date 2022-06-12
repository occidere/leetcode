class Solution {
    fun findMinArrowShots(points: Array<IntArray>) = points.sortedBy { it.first() }
        .run {
            var merged = first()
            1 + drop(1).map {
                if (merged.hasIntersectionWith(it)) {
                    merged = merged.getIntersection(it)
                    0
                } else {
                    merged = it
                    1
                }
            }.sum()
        }

    private fun IntArray.hasIntersectionWith(other: IntArray) = !(last() < other.first() || other.last() < first())

    private fun IntArray.getIntersection(other: IntArray) = intArrayOf(
        kotlin.math.max(first(), other.first()),
        kotlin.math.min(last(), other.last())
    )
}
