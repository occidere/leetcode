/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-06
 */
class Solution {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>) = points.indices
        .zip(points)
        .asSequence()
        .filter { it.second[0] == x || it.second[1] == y }
        .map { it.first to kotlin.math.abs(it.second[0] - x) + kotlin.math.abs(it.second[1] - y) }
        .sortedWith(Comparator { p1, p2 -> if (p1.second == p2.second) p1.first - p2.first else p1.second - p2.second })
        .map { it.first }
        .firstOrNull() ?: -1
}
