import kotlin.math.max

class Solution {
    fun mctFromLeafValues(arr: IntArray): Int {
        var acc = 0
        var a = arr

        while (a.size > 1) {
            var x = 0
            var y = 1
            var minProduct = a[x] * a[y]

            for (i in 2 until a.size) {
                val p = a[i - 1] * a[i]
                if (p < minProduct) {
                    minProduct = p
                    x = i - 1
                    y = i
                }
            }

            a = a.sliceArray(0 until x) + max(a[x], a[y]) + a.sliceArray(y + 1 until a.size)
            acc += minProduct
        }

        return acc
    }
}