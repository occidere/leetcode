import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int = cost.indices.forEach { i ->
        cost[i] += if (i < 2) 0 else min(cost[i - 2], cost[i - 1])
    }.let { min(cost[cost.size - 2], cost.last()) }
}
