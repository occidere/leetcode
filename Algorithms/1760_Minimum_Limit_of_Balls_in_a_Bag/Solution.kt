/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-21
 */
class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int) = nums.sorted()
        .toIntArray()
        .findMinBucketSize(maxOperations)

    private fun IntArray.findMinBucketSize(maxOps: Int): Int {
        var minBucketSize = last()
        var (left, right) = 1 to last()
        while (left < right) {
            val mid = (left + right).shr(1)
            val upperBoundIdx = upperBound(mid)
            val additionalBuckets = drop(upperBoundIdx).getAdditionalBuckets(mid)
            if (additionalBuckets <= maxOps && mid < minBucketSize) {
                minBucketSize = mid
                right = mid
            } else {
                left = mid + 1
            }
        }
        return minBucketSize
    }

    private fun IntArray.upperBound(target: Int): Int {
        var (left, right) = 0 to size
        while (left < right) {
            val mid = (left + right).shr(1)
            if (this[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return right
    }

    private fun List<Int>.getAdditionalBuckets(bucketSize: Int) =
        sumBy { -1 + (it / bucketSize) + if (it % bucketSize == 0) 0 else 1 }
}
