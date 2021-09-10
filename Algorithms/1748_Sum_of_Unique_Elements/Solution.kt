class Solution {
    fun sumOfUnique(nums: IntArray) = nums.groupBy { it }
        .filter { it.value.size == 1 }
        .map { it.key }
        .sum()
}
