class Solution {
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int = nums1.sorted()
            .zip(nums2.sortedDescending())
            .map { it.first * it.second }
            .sum()
}
