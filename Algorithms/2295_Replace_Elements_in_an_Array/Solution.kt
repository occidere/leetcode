class Solution {
    fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
        val posMap = nums.indices.associateBy { nums[it] }.toMutableMap()
        for ((x, y) in operations) {
            val pos = posMap[x]!!
            posMap.remove(x)
            posMap[y] = pos
        }
        return nums.apply { posMap.forEach { (k, v) -> this[v] = k } }
    }
}
