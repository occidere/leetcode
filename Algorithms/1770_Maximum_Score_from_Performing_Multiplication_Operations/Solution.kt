/**
 * Ref: https://me2.do/GcWY0KCQ
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-16
 */
class Solution {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val dp = Array(multipliers.size) { Array<Int?>(multipliers.size) { null } }

        fun solve(left: Int, i: Int): Int =
            if (i == multipliers.size) {
                0
            } else if (dp[left][i] != null) {
                dp[left][i]!!
            } else {
                kotlin.math.max(
                    solve(left + 1, i + 1) + nums[left] * multipliers[i], // pick left
                    solve(left, i + 1) + nums[nums.size - (i - left) - 1] * multipliers[i] // pick right
                ).let { dp[left][i] = it; it }
            }

        return solve(0, 0)
    }
}
