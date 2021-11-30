class Solution {
    fun targetIndices(nums: IntArray, target: Int) = nums.sorted()
        .zip(nums.indices)
        .filter { it.first == target }
        .map { it.second }
}
