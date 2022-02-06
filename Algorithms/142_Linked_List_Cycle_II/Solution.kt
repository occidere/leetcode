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
    fun detectCycle(head: ListNode?): ListNode? {
        var tortoise = head
        var hare = head
        do {
            tortoise = tortoise?.next
            hare = hare?.next?.next
            // Stop if no cycle or tortoise and hare met
        } while (hare != null && tortoise != hare)

        // Cycle exist
        var cycleStartNode: ListNode? = null
        if (hare != null) {
            tortoise = head
            while (tortoise != hare) {
                tortoise = tortoise!!.next
                hare = hare!!.next
            }
            cycleStartNode = tortoise
        }

        return cycleStartNode
    }
}
