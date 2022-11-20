/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-20
 */
class Solution {
    fun unequalTriplets(nums: IntArray): Int {
        var cnt = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i]) {
                        ++cnt
                    }
                }
            }
        }
        return cnt
    }
}
