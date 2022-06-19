class Solution {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val (aArea, bArea) = (ax2 - ax1) * (ay2 - ay1) to (bx2 - bx1) * (by2 - by1)
        val (isCoveredX, isCoveredY) = !(ax2 < bx1 || bx2 < ax1) to !(ay2 < by1 || by2 < ay1)
        return aArea + bArea - if (isCoveredX && isCoveredY) {
            val (x1, x2) = listOf(ax1, ax2, bx1, bx2).sorted().let { it[1] to it[2] }
            val (y1, y2) = listOf(ay1, ay2, by1, by2).sorted().let { it[1] to it[2] }
            (x2 - x1) * (y2 - y1)
        } else 0
    }
}
