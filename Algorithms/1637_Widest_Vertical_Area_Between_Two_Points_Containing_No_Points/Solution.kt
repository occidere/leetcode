class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int = points.map { it.first() }
        .sorted()
        .zipWithNext { x, y -> y - x }
        .max()!!
}
