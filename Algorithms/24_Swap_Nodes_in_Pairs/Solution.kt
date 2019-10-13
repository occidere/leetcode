import java.util.*

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
    fun swapPairs(head: ListNode?): ListNode? {
        var h = head
        val stack: Stack<ListNode> = Stack()
        while (h != null) {
            stack.push(h)
            h = h.next
        }

        if (stack.size % 2 == 1) {
            h = stack.pop()
        }

        while (stack.isNotEmpty()) {
            val n1 = stack.pop()
            val n2 = stack.pop()
            n2.next = h
            n1.next = n2
            h = n1
        }

        return h
    }
}
