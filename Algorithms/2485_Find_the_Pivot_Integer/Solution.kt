/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-27
 */
class Solution {
    fun pivotInteger(n: Int): Int {
        if (n == 1) {
            return 1
        }
        var (left, right) = 1 to n
        while (left < right) {
            val mid = (left + right).shr(1)
            val (leftSum, rightSum) = Pair(1, mid).sum() to Pair(mid, n).sum()
            if (leftSum == rightSum) {
                return mid
            } else if (leftSum < rightSum) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }

    private fun Pair<Int, Int>.sum(): Int = ((first + second) * (second - first + 1)).shr(1)
}
