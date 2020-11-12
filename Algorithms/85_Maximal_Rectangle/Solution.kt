import java.util.*
import kotlin.math.max

class Solution {
    fun maximalRectangle(matrix: Array<CharArray>) = if (matrix.isEmpty()) 0 else {
        var prevHistogram = IntArray(matrix[0].size) { 0 }
        matrix.map { mat ->
            prevHistogram = prevHistogram.indices
                    .map { if (mat[it] == '0') 0 else prevHistogram[it] + 1 }
                    .toIntArray()
            prevHistogram
        }.map { getMaxArea(it) }.max()!!
    }

    private fun getMaxArea(height: IntArray): Int {
        var maxArea = 0
        val stk = Stack<Int>()

        for (i in height.indices) {
            while (stk.isNotEmpty() && height[i] < height[stk.peek()]) {
                val h = height[stk.pop()]
                val w = if (stk.isEmpty()) i else i - stk.peek() - 1
                maxArea = max(maxArea, h * w)
            }
            stk.push(i)
        }

        while (stk.isNotEmpty()) {
            val h = height[stk.pop()]
            val w = if (stk.isEmpty()) height.size else height.size - stk.peek() - 1
            maxArea = max(maxArea, h * w)
        }

        return maxArea
    }
}