/**
 * Ref: https://me2.do/51nC0KTx
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-20
 */
class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        var res = 0
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) { 0 } }
        for (i in nums1.indices.reversed()) {
            for (j in nums2.indices.reversed()) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1
                    res = kotlin.math.max(res, dp[i][j])
                }
            }
        }
        return res
    }
}
