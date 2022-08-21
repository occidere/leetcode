/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-21
 */
class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray) = Pair(nums1.toSet(), nums2.toSet())
        .let { (xs, ys) -> listOf(xs.subtract(ys).toList(), ys.subtract(xs).toList()) }
}
