class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val (left, right) =
            longArrayOf(0 /* sum */, 0 /* len */) to longArrayOf(nums.map { it.toLong() }.sum(), nums.size.toLong())
        return IntArray(nums.size).apply {
            for (i in nums.indices) {
                if (left[1] != 0L) {
                    this[i] += (nums[i] * left[1] - left[0]).toInt()
                }
                left[0] = left[0] + nums[i]
                ++left[1]

                if (right[1] != 0L) {
                    this[i] += (right[0] - right[1] * nums[i]).toInt()
                }
                right[0] = right[0] - nums[i]
                --right[1]
            }
        }
    }
}
