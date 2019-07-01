/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import java.util.*

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
	val pq = PriorityQueue<Int>()
	lists.forEach { unleash(it, pq) }

	val node = ListNode(0) // fake node
	var head: ListNode? = node
	while (pq.isNotEmpty()) {
	    head!!.next = ListNode(pq.poll())
	    head = head.next
	}
	return node.next
    }

    private fun unleash(node: ListNode?, pq: PriorityQueue<Int>) {
	var head = node
	while (head != null) {
	    pq.offer(head.`val`)
	    head = head.next
	}
    }
}
