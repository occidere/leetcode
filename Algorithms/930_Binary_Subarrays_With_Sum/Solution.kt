/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-12-19
 */
class Solution {
    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        var ans = 0
        var prevAcc = 0

        for (len in 1..A.size) {
            var left = 0
            var right = len - 1

            val curAcc = prevAcc + A[right]
            var acc: Int = curAcc

            ans += if (acc == S) 1 else 0
            repeat(A.size - len) {
                acc = acc - A[left++] + A[++right]
                ans += if (acc == S) 1 else 0
            }

            prevAcc = curAcc
        }

        return ans
    }
}