// Ref: https://leetcode.com/problems/tuple-with-same-product/discuss/1020600/JAVA-Simple-Solution-with-HashMap-(7-lines)/962428
class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        var res = 0
        val prodMap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val prod = nums[i] * nums[j]
                val freq = prodMap.getOrDefault(prod, 0)
                res += freq
                prodMap[prod] = freq + 1
            }
        }
        return res.shl(3)
    }
}
