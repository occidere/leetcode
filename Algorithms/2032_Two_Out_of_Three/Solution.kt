class Solution {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray) = listOf(nums1, nums2, nums3)
        .flatMap { it.distinct() }
        .groupBy { it }
        .filter { it.value.size > 1 }
        .keys
        .toList()
}
