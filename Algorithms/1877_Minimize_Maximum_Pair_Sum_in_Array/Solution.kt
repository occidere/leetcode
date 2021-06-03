class Solution {
    fun minPairSum(nums: IntArray): Int = nums.sorted()
            .zip(nums.sortedDescending())
            .map { it.first + it.second }
            .take(nums.size shr 1)
            .max()!!
}
