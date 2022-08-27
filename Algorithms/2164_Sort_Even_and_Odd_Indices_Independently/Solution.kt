/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-27
 */
class Solution {
    fun sortEvenOdd(nums: IntArray) = nums.indices
        .groupBy({ it % 2 }) { nums[it] }
        .let { Pair(it[0]?.sorted() ?: emptyList<Int>(), it[1]?.sortedDescending() ?: emptyList()) }
        .let { (evens, odds) ->
            evens.zip(odds)
                .flatMap { (a, b) -> listOf(a, b) } +
                    (if (evens.size > odds.size) listOf(evens.last()) else emptyList())
        }.toIntArray()
}
