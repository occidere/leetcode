import kotlin.math.max

class Solution {
    fun findLHS(nums: IntArray): Int = nums.groupBy { it }
        .mapValues { it.value.size }
        .withDefault { 0 }
        .run {
            map {
                max(this.getValue(it.key + 1), this.getValue(it.key - 1))
                    .run { if (this == 0) 0 else this + it.value }
            }.max()!!
        }
}