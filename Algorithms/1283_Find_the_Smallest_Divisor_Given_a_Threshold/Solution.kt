/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-22
 */
class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        nums.sort()
        var minD = nums.last() + 1
        var (left, right) = 1 to nums.last() + 1
        while (left < right) {
            val mid = (left + right).shr(1)
            if (mid < minD && nums.dividedSum(mid) <= threshold) {
                minD = mid
                right = mid
            } else {
                left = mid + 1
            }
        }

        return minD
    }

    private fun IntArray.dividedSum(d: Int) = sumBy { it / d + if (it % d == 0) 0 else 1 }
}
