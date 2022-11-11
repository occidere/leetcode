/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-11
 */
class Solution {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val res = mutableSetOf<Int>()
        for (i in nums.indices) {
            for (j in i..kotlin.math.min(i + k, nums.size - 1)) {
                if (nums[i] == key || nums[j] == key) {
                    res.add(i)
                    res.add(j)
                }
            }
        }
        return res.sorted()
    }
}
