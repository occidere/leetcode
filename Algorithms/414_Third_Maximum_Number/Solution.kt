/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-08
 */
class Solution {
    fun thirdMax(nums: IntArray) = nums.asSequence()
        .distinct()
        .sortedDescending()
        .take(3)
        .toList()
        .let { if (it.size < 3) it.first() else it.last() }
}
