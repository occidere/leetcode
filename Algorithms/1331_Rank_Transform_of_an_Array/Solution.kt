/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2023-01-01
 */
class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val rankMap = arr.asSequence()
            .toSortedSet()
            .withIndex()
            .associate { (i, x) -> x to i + 1 }
        return arr.map { rankMap[it]!! }.toIntArray()
    }
}
