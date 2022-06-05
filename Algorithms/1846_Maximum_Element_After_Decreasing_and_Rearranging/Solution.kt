class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray) =
        if (arr.size == 1) 1 else arr.sorted()
            .run { listOf(1) + drop(1) }
            .toTypedArray()
            .also {
                for (i in 1 until it.size) {
                    if (it[i] - it[i - 1] > 1) {
                        it[i] = kotlin.math.min(it[i - 1] + 1, it[i])
                    }
                }
            }.last()
}
