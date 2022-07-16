/**
 * Ref: https://me2.do/FqlPzdnn
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-07-16
 */
class Solution {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val dxy = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        var prevMap = Array(m) { IntArray(n) { 0 } }
        prevMap[startRow][startColumn] = 1

        var res = 0
        repeat(maxMove) {
            val curMap = Array(m) { IntArray(n) { 0 } }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    for (d in dxy) {
                        val (ai, aj) = i + d[0] to j + d[1]
                        if (ai in 0 until m && aj in 0 until n) {
                            curMap[ai][aj] = (curMap[ai][aj] + prevMap[i][j]) % 1000000007
                        } else {
                            res = (res + prevMap[i][j]) % 1000000007
                        }
                    }
                }
            }
            prevMap = curMap
        }

        return res
    }
}
