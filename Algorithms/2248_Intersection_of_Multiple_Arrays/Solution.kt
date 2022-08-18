/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-08-18
 */
class Solution {
    fun intersection(nums: Array<IntArray>) = nums.map { it.toSet() }
        .reduce { acc, ints -> acc.intersect(ints) }
        .sorted()
}
