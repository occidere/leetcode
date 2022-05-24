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
    fun nextLargerNodes(head: ListNode): IntArray {
        val n = head.size()
        val res = IntArray(n) { 0 }
        val stk = java.util.Stack<Pair<Int, Int>>() // idx, nodeVal
        var h: ListNode? = head
        for (i in 0 until n) {
            while (stk.isNotEmpty() && stk.peek().second < h!!.`val`) {
                res[stk.pop().first] = h.`val`
            }
            stk.push(i to h!!.`val`)
            h = h.next
        }
        return res
    }

    private fun ListNode.size(): Int {
        var head: ListNode? = this
        var n = 0
        while (head != null) {
            ++n
            head = head.next
        }
        return n
    }
}
