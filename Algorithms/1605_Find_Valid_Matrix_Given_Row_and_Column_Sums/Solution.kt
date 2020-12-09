import kotlin.math.min

class Solution {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val arr = Array(rowSum.size) { IntArray(colSum.size) { 0 } }

        for (i in rowSum.indices) {
            for (j in colSum.indices) {
                if (rowSum[i] == 0) break
                val k = min(rowSum[i], colSum[j])
                arr[i][j] = k
                rowSum[i] -= k
                colSum[j] -= k
            }
        }

        return arr
    }
}