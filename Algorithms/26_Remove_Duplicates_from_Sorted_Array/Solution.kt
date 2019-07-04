class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        return if (nums.isEmpty()) {
            0
        } else {
            var cnt = 1
            for (i in 1 until nums.size) {
                if (nums[i] != nums[i - 1]) {
                    nums[cnt] = nums[i]
                    cnt++
                }
            }
            cnt
        }
    }
}
