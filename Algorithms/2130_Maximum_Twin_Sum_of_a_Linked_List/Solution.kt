import java.util.*
import kotlin.math.max

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
    fun pairSum(head: ListNode?): Int {
        val stk = Stack<ListNode>()
        var (slow, fast) = head to head
        while (fast?.next != null) {
            stk.push(slow)
            slow = slow!!.next
            fast = fast.next!!.next
        }

        var maxTwinSum = 0
        while (stk.isNotEmpty()) {
            maxTwinSum = max(maxTwinSum, stk.pop().`val` + slow!!.`val`)
            slow = slow.next
        }
        return maxTwinSum
    }
}
