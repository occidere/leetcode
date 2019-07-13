class Solution {
    private var res = intArrayOf(-1, -1)
    fun searchRange(nums: IntArray, target: Int): IntArray {
        find(nums, 0, nums.size - 1, target)
        return res
    }

    private fun find(nums: IntArray, from: Int, to: Int, target: Int) {
        if (from > to) {
            return
        }

        val mid = (from + to) / 2
        if (target == nums[mid]) {
            if (res[0] == -1 || mid < res[0]) {
                res[0] = mid
            }
            if (res[1] == -1 || mid > res[1]) {
                res[1] = mid
            }
        }
        find(nums, from, mid - 1, target)
        find(nums, mid + 1, to, target)
    }
}
