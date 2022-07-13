/**
 * Ref: https://leetcode.com/problems/sum-of-square-numbers/solution/
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-13
 */
class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0L
        while (a * a <= c) {
            if (bSearch(c - a * a)) {
                return true
            }
            ++a
        }
        return false
    }

    private fun bSearch(target: Long): Boolean {
        var (left, right) = 0L to target
        while (left <= right) {
            val mid = (left + right).shr(1)
            val sqrSum = mid * mid
            if (sqrSum == target) {
                return true
            } else if (sqrSum < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}
