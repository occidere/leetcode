/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-16
 */
class Solution {
    fun countDistinctIntegers(nums: IntArray) = nums.joinToString(",")
        .run { "$this,${reversed()}" }
        .split(",")
        .map { it.toInt() }
        .toSet()
        .size
}
