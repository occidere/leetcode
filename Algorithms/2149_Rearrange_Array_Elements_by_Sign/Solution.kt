class Solution {
    fun rearrangeArray(nums: IntArray) = nums.filter { it > 0 }
        .zip(nums.filter { it < 0 })
        .flatMap { listOf(it.first, it.second) }
        .toIntArray()
}
