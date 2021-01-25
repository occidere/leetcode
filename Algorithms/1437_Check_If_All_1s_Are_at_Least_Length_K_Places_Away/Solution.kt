class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean = nums.zip(nums.indices)
        .filter { it.first == 1 }
        .map { it.second }
        .run {
            this.isEmpty() || this.zipWithNext().find { it.second - it.first - 1 < k } == null
        }
}