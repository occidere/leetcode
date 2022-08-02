/**
 * Ref: https://me2.do/5Bx3DIRP
 * 
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-02
 */
class Solution {
    fun smallestRangeII(nums: IntArray, k: Int): Int {
        nums.sort()
        var minDiff = nums.last() - nums.first()
        for (i in 0 until nums.size - 1) {
            val high = kotlin.math.max(nums.last() - k, nums[i] + k)
            val low = kotlin.math.min(nums.first() + k, nums[i + 1] - k)
            minDiff = kotlin.math.min(minDiff, high - low)
        }
        return minDiff
    }
}
