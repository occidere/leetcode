import java.util.Stack

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-28
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNodes(head: ListNode): ListNode? {
        val stk = Stack<ListNode>()
        var newHead: ListNode? = head
        while (newHead != null) {
            while (stk.isNotEmpty() && stk.peek().`val` < newHead.`val`) {
                stk.pop()
            }
            stk.push(newHead)
            newHead = newHead.next
        }

        newHead = ListNode(0)
        val res: ListNode = newHead
        for (node in stk.toList()) {
            newHead!!.next = node
            newHead = node
        }
        newHead?.next = null
        return res.next
    }
}
