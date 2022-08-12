/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-12
 */
class Solution {
    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>) =
        (items1 + items2).groupBy({ it[0] }, { it[1] })
            .map { listOf(it.key, it.value.sum()) }
            .sortedBy { it.first() }
}
