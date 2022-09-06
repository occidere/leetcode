/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-06
 */
class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var maxSum = 0
        var acc = nums.first()
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                maxSum = kotlin.math.max(maxSum, acc)
                acc = nums[i]
            } else {
                acc += nums[i]
            }
        }
        return kotlin.math.max(maxSum, acc)
    }
}
