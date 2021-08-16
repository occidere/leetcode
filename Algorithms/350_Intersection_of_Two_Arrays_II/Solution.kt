import kotlin.math.min

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val g1 = nums1.groupBy { it }.map { it.key to it.value.size }.toMap()
        val g2 = nums2.groupBy { it }.map { it.key to it.value.size }.toMap()
        return intArrayOf(*nums1, *nums2).toSet()
            .map { it to (min(g1.getOrDefault(it, 0), g2.getOrDefault(it, 0))) }
            .flatMap { p -> List(p.second) { p.first } }
            .toIntArray()
    }
}
