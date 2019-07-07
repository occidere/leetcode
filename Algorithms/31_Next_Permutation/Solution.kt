class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        for (i in nums.size - 1 downTo 1) {
            if (nums[i - 1] < nums[i]) {
                val nextIdx = findNextGreaterIndex(nums, i - 1)
                nums[i - 1] = nums[nextIdx].also { nums[nextIdx] = nums[i - 1] }
                nums.sort(i, nums.size)
                return
            }
        }
        nums.sort()
    }

    private fun findNextGreaterIndex(nums: IntArray, curIdx: Int): Int {
        var nextNum = Int.MAX_VALUE
        var nextIdx = -1
        for (i in curIdx + 1 until nums.size) {
            if (nums[curIdx] < nums[i] && nums[i] < nextNum) {
                nextNum = nums[i]
                nextIdx = i
            }
        }
        return nextIdx
    }
}
