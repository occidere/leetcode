/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-11
 */
class Solution {
    fun numberOfPairs(nums: IntArray) = nums.groupBy { it }
        .values
        .map { intArrayOf(it.size.shr(1), it.size % 2) }
        .reduce { acc, pair -> intArrayOf(acc[0] + pair[0], acc[1] + pair[1]) }
}
