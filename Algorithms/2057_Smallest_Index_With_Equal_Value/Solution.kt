class Solution {
    fun smallestEqual(nums: IntArray) = nums.withIndex().firstOrNull { it.index.rem(10) == it.value }?.index ?: -1
}
