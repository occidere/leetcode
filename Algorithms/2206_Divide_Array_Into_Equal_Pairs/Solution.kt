class Solution {
    fun divideArray(nums: IntArray): Boolean {
        nums.sort()
        for (i in 0.until(nums.size).step(2)) {
            if (nums[i] != nums[i + 1]) {
                return false
            }
        }
        return true
    }
}
