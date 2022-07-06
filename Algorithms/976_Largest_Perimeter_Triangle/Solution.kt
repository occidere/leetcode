/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-06
 */
class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sortDescending()
        for (i in 0 until nums.size - 2) {
            if (nums[i] < nums[i + 1] + nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2]
            }
        }
        return 0
    }
}
