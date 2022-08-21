/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-21
 */
class Solution {
    fun minSubsequence(nums: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        var (sumA, sumB) = nums.sum() to 0
        for (n in nums.sortedDescending()) {
            if (sumA < sumB) {
                break
            }
            ans.add(n)
            sumA -= n
            sumB += n
        }
        return ans
    }
}
