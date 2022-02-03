class Solution {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray) = nums1.toCountedMapWith(nums2).let { xs ->
        nums3.toCountedMapWith(nums4).let { ys ->
            xs.map { it.value * ys.getOrDefault(-it.key, 0) }.sum()
        }
    }

    private fun IntArray.toCountedMapWith(arr: IntArray) = indices.flatMap { i -> arr.indices.map { j -> this[i] + arr[j] } }
        .groupBy { it }
        .map { it.key to it.value.size }
        .toMap()
}
