/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-18
 */
class Solution {
    fun isMonotonic(nums: IntArray) = nums.toList()
        .zipWithNext()
        .run { all { it.first >= it.second } || all { it.first <= it.second } }
}
