class Solution {
    fun subsetXORSum(nums: IntArray, idx: Int = 0, visit: Set<Int> = setOf()): Int {
        var acc = visit.map { nums[it] }.let { if (it.isEmpty()) 0 else it.reduce { x, y -> x.xor(y) } }
        for (i in idx.until(nums.size)) {
            if (!visit.contains(i)) {
                acc += subsetXORSum(nums, i, visit + i)
            }
        }
        return acc
    }
}
