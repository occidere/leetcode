/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-20
 */
class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> = arr.sorted()
        .zipWithNext()
        .map { kotlin.math.abs(it.first - it.second) to listOf(it.first, it.second) }
        .groupBy({ it.first }) { it.second }
        .toSortedMap()
        .values
        .first()
}
