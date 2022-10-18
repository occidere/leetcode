/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-17
 */
class Solution {
    fun findMaxK(nums: IntArray) = nums.toSet()
        .let { sets -> sets.filter { sets.contains(-it) }.max() ?: -1 }
}
