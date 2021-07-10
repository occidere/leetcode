import kotlin.math.max

class Solution {
    fun sortString(s: String): String {
        var maxY = 0
        val arr = s.groupBy { it }
                .toSortedMap()
                .map { x ->
                    x.value.map { it.toString() }
                            .toTypedArray()
                            .apply { maxY = max(maxY, size) }
                }.toTypedArray()
        for (i in arr.indices) {
            arr[i] += (0 until maxY - arr[i].size)
                    .map { "" }
                    .toTypedArray()
        }

        val maxX = arr.size
        val res = mutableListOf<String>()
        for (i in 0 until maxY) {
            val range = if (i % 2 == 0) 0 until maxX else maxX - 1 downTo 0
            for (j in range) {
                res += arr[j][i]
            }
        }

        return res.joinToString("")
    }
}
