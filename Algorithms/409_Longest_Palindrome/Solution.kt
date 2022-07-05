/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-05
 */
class Solution {
    fun longestPalindrome(s: String) = s.groupBy { it }
        .values
        .map { it.size }
        .groupBy { it % 2 }
        .withDefault { listOf(0) }
        .run {
            getValue(0).sum() + getValue(1)
                .sortedDescending()
                .run { first() + drop(1).map { kotlin.math.max(0, it - 1) }.sum() }
        }
}
