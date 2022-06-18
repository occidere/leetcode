class Solution {
    private val ans = mutableSetOf<List<Int>>()

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        for (i in nums.indices) {
            nums.solve(i, mutableListOf(nums[i]))
        }
        return ans.toList()
    }

    private fun IntArray.solve(idx: Int, acc: MutableList<Int>) {
        for (i in idx + 1 until size) {
            if (acc.last() <= this[i]) {
                acc += this[i]
                ans += acc.toList()
                solve(i, acc)
                acc.removeAt(acc.size - 1)
            }
        }
    }
}
