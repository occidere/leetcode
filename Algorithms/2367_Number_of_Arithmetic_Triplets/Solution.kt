/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-09
 */
class Solution {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val res = mutableSetOf<Triple<Int, Int, Int>>()
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        res.add(Triple(i, j, k))
                    }
                }
            }
        }
        return res.size
    }
}
