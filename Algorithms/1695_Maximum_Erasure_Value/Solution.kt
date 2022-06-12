import kotlin.math.max

class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var (i, j) = 0 to 0
        var (acc, maxSum) = 0 to 0
        val visit = mutableSetOf<Int>()
        while (j < nums.size) {
            val k = nums[j++]
            if (visit.contains(k)) {
                while (true) {
                    val prev = nums[i++]
                    acc -= prev
                    visit.remove(prev)
                    if (prev == k) {
                        break
                    }
                }
            }
            visit += k
            acc += k
            maxSum = max(maxSum, acc)
        }
        return max(maxSum, acc)
    }
}
