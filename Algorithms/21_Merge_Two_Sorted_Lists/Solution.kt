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
    private var h1: ListNode? = null
    private var h2: ListNode? = null
    private var head: ListNode? = null

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val node = ListNode(0) // Start with fake node
        head = node; h1 = l1; h2 = l2

        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                if (h1!!.`val` < h2!!.`val`) {
                    move(true)
                } else {
                    move(false)
                }
            } else if (h1 != null) {
                move(true)
            } else {
                move(false)
            }
        }
        return node.next
    }

    private fun move(moveHead1: Boolean) {
        if (moveHead1) {
            head?.next = h1
            h1 = h1?.next
        } else {
            head?.next = h2
            h2 = h2?.next
        }
        head = head?.next
    }
}
