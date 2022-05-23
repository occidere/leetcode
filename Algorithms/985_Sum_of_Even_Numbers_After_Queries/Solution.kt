class Solution {
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size) { 0 }
        var acc = nums.filter { it % 2 == 0 }.sum()
        for (i in queries.indices) {
            val (before, after) = nums[queries[i][1]] to nums[queries[i][1]] + queries[i][0]
            acc += (if (after % 2 == 0) after else 0) - (if (before % 2 == 0) before else 0)
            nums[queries[i][1]] = after
            ans[i] = acc
        }
        return ans
    }
}
