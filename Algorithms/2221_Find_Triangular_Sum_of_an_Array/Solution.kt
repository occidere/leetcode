class Solution {
    fun triangularSum(nums: IntArray) = nums.apply {
        repeat(size - 1) {
            1.until(size - it).forEach { i -> this[i - 1] = (this[i - 1] + this[i]) % 10 }
        }
    }.first()
}
