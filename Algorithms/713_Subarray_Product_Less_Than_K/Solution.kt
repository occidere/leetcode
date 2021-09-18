class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) {
            return 0
        }

        var (ans, left, prod) = Triple(0, 0, 1)
        for (right in nums.indices) {
            prod *= nums[right]
            while (prod >= k) {
                prod /= nums[left++]
            }
            ans += right - left + 1
        }
        return ans
    }
}
