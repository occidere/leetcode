/**
 * Ref: https://me2.do/5FZObMte
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-26
 */
class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefixSum = IntArray(nums.size + 1) { 0 }
        for (i in 1..nums.size) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]
        }

        val set = mutableSetOf<Int>()
        for (i in 2..nums.size) {
            set.add(prefixSum[i - 2] % k)
            if (set.contains(prefixSum[i] % k)) {
                return true
            }
        }

        return false
    }
}
