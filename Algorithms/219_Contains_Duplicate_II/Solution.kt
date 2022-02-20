import kotlin.math.abs

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int) = nums.groupBy { it }
        .filter { it.value.size > 1 }
        .keys
        .map { n -> nums.indices.filter { nums[it] == n }.toIntArray() }
        .any {
            for (i in 1 until it.size) {
                if (abs(it[i] - it[i - 1]) <= k) {
                    return true
                }
            }
            false
        }
}
