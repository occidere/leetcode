class Solution {
    fun numOfPairs(nums: Array<String>, target: String) = nums.indices
        .flatMap { i ->
            nums.indices.map { j ->
                if (i != j) nums[i] + nums[j] else ""
            }
        }.filter { it == target }
        .size
}
