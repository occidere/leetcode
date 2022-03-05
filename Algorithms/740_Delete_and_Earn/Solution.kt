class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val freq = nums.groupBy { it }
            .map { it.key to it.value.size }
            .toMap()
        val d = IntArray(10001) { 0 }
        for (i in d.indices) {
            d[i] = i * freq.getOrDefault(i, 0) +
                    kotlin.math.max(
                        if (i > 1) d[i - 2] else 0,
                        if (i > 2) d[i - 3] else 0
                    )
        }
        return d.max()!!
    }
}
