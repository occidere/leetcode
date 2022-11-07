/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-07
 */
class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i].shl(1)
                nums[i + 1] = 0
            }
        }
        return nums.filter { it != 0 }
            .let { it + (1..(nums.size - it.size)).map { 0 } }
            .toIntArray()
    }
}
