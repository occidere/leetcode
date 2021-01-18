import kotlin.math.min

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int = nums.map { it to 1 }
        .fold(mutableMapOf<Int, Int>().withDefault { 0 }) { m, p ->
            m[p.first] = m.getValue(p.first) + 1; m
        }.run {
            val visit = mutableSetOf<Int>()
            (if (k % 2 == 0) (this.getValue(k / 2) / 2).also { visit += k / 2 } else 0) +
                    this.map {
                        if (it.key in visit) 0
                        else min(this.getValue(k - it.key), it.value).apply { visit += k - it.key }
                    }.sum()
        }
}