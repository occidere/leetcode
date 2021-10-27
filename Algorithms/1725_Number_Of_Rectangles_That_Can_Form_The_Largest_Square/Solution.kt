class Solution {
    fun countGoodRectangles(rectangles: Array<IntArray>) = rectangles
        .map { if (it[0] < it[1]) it[0] else it[1] }
        .let { minSides ->
            minSides.max()!!.let { maxSqrSide ->
                minSides.count { it >= maxSqrSide }
            }
        }
}
