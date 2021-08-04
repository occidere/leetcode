class Solution {
    private val powerSets = mutableListOf<List<Int>>()

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        nums.indices.forEach { dfs(nums, it, listOf(nums[it])) }
        return listOf<List<Int>>(listOf()) + powerSets.distinct()
    }

    private fun dfs(nums: IntArray, idx: Int, acc: List<Int>) {
        powerSets += acc
        if (idx < nums.size) {
            (idx + 1 until nums.size).forEach { dfs(nums, it, acc + nums[it]) }
        }
    }
}
