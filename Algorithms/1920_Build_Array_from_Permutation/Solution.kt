class Solution {
    fun buildArray(nums: IntArray): IntArray = nums.indices.map { nums[nums[it]] }.toIntArray()
}
