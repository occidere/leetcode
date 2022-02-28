class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val sumRange = mutableListOf<Pair<Int, Int>>()
        if (nums.isNotEmpty()) {
            var i = 0
            for (j in 1 until nums.size) {
                if (nums[j].toLong() - nums[j - 1].toLong() > 1L) {
                    sumRange += nums[i] to nums[j - 1]
                    i = j
                }
            }
            sumRange += nums[i] to nums.last()
        }
        return sumRange.map { if (it.first == it.second) "${it.first}" else "${it.first}->${it.second}" }
    }
}
