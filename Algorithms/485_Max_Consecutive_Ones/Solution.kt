class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray) = nums.joinToString("")
        .split("0")
        .map { it.length }
        .max()!!
}
