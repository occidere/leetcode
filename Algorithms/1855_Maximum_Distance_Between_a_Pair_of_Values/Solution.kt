/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-14
 */
class Solution {

    // Two Pointer: O(N)
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var (i, j, d) = Triple(0, 0, 0)
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] > nums2[j]) {
                ++i
            } else {
                d = kotlin.math.max(d, j++ - i)
            }
        }
        return d
    }

    // Binary Search: O(NlogN)
//    fun maxDistance(nums1: IntArray, nums2: IntArray) = nums1.zip(nums1.indices)
//        .map { (num1, i) ->
//            val j = nums2.bSearch(num1)
//            (0 <= j && i <= j && num1 <= nums2[j]) to (j - i)
//        }.filter { it.first }
//        .map { it.second }
//        .max() ?: 0
//
//    private fun IntArray.bSearch(target: Int): Int {
//        var (left, right) = 0 to size
//        while (left < right) {
//            val mid = (left + right).shr(1)
//            if (this[mid] >= target) {
//                left = mid + 1
//            } else {
//                right = mid
//            }
//        }
//        return right - 1
//    }
}
