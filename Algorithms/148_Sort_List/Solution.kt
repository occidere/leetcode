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
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val midNode = head.getMidNode()
        return merge(sortList(head), sortList(midNode))
    }

    private fun merge(left: ListNode?, right: ListNode?): ListNode? {
        var leftHead: ListNode? = left
        var rightHead: ListNode? = right
        val fakeNode = ListNode(0)
        var fakeHead: ListNode = fakeNode
        while (leftHead != null && rightHead != null) {
            if (leftHead.`val` < rightHead.`val`) {
                fakeHead.next = leftHead
                leftHead = leftHead.next
            } else {
                fakeHead.next = rightHead
                rightHead = rightHead.next
            }
            fakeHead = fakeHead.next!!
        }
        fakeHead.next = leftHead ?: rightHead
        return fakeNode.next
    }

    // Find mid starting node and split with previous node
    private fun ListNode.getMidNode(): ListNode {
        var slow: ListNode? = this
        var fast: ListNode? = this
        var prevMidNode: ListNode? = null
        while (fast?.next != null) {
            prevMidNode = prevMidNode?.next ?: slow
            fast = fast.next?.next
            slow = slow?.next
        }
        prevMidNode?.next = null
        return slow!!
    }
}
