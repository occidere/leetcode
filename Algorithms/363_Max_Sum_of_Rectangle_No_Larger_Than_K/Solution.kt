import java.util.*
import kotlin.math.max

/**
 * Ref: https://me2.do/x78OShnT
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-27
 */
class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var res = -0x3f3f3f3f
        for (r1 in matrix.indices) {
            val arr = IntArray(matrix[0].size) { 0 }
            for (r2 in r1 until matrix.size) {
                for (c in matrix[0].indices) {
                    arr[c] += matrix[r2][c]
                }
                res = max(res, arr.maxSubSum(k))
            }
        }
        return res
    }

    private fun IntArray.maxSubSum(k: Int): Int {
        val bst = TreeSet<Int>().apply { add(0) }
        var (res, right) = -0x3f3f3f3f to 0
        for (num in this) {
            right += num
            res = max(res, bst.ceiling(right - k)?.let { left -> right - left } ?: -0x3f3f3f3f)
            bst.add(right)
        }
        return res
    }
}
