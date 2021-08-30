class Solution {
    fun arrayPairSum(nums: IntArray) = nums.sorted()
        .zip(nums.indices)
        .filter { it.second % 2 == 0 }
        .map { it.first }
        .sum()
}
