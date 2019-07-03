mport java.util.*

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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
	return if (k == 1) {
	    head
	} else {
	    val stack: Stack<ListNode> = Stack()
	    var newHead = head
	    while (newHead != null) {
	        stack.push(newHead)
		newHead = newHead.next
	    }

	    for (i in 1..stack.size % k) {
		newHead = stack.pop()
	    }

	    while (stack.isNotEmpty()) {
		val front = stack.pop()
	        var tmpHead = front
	        for (i in 1 until k) {
		    tmpHead.next = stack.pop()
		    tmpHead = tmpHead.next
		}
		tmpHead.next = newHead
		newHead = front
	    }

	    newHead
	}
    }
}
