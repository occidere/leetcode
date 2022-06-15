class Solution {
    fun reductionOperations(nums: IntArray): Int {
        val sorted = (listOf(Int.MAX_VALUE) + nums.sortedDescending()).toTypedArray()
        var ops = 0
        for (i in 1 until sorted.size) {
            if (sorted[i - 1] > sorted[i]) {
                ops += (i - 1)
            }
        }
        return ops
    }
}
