/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    private var di = 0
    private val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val arr = Array(m) { IntArray(n) { -2 } }
        var (cur, node) = (0 to 0) to head
        for (i in 0 until m * n) {
            arr[cur.first][cur.second] = node?.`val`?.apply { node = node?.next } ?: -1
            cur = arr.getNextFrom(cur)
        }
        return arr
    }

    private fun Array<IntArray>.getNextFrom(cur: Pair<Int, Int>) =
        (cur.first + d[di][0] to cur.second + d[di][1]).let { next ->
            if (canMoveTo(next)) next else {
                di = (di + 1) % 4
                cur.first + d[di][0] to cur.second + d[di][1]
            }
        }

    private fun Array<IntArray>.canMoveTo(next: Pair<Int, Int>) =
        next.first in indices && next.second in first().indices && this[next.first][next.second] == -2
}
