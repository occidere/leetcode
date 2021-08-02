import kotlin.math.abs

class Solution {
    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>) = queries.map { q ->
        points.filter { p ->
            q[2] * q[2] >=
                    abs(p[0] - q[0]).let { it * it } +
                    abs(p[1] - q[1]).let { it * it }
        }.count()
    }.toIntArray()
}
