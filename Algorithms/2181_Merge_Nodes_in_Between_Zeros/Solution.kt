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
    fun mergeNodes(head: ListNode): ListNode {
        var (prev, zeroNode, node) = Triple(ListNode(0), head, head)
        while (node.next != null) {
            node = node.next!!
            if (node.`val` == 0) {
                prev = zeroNode
                zeroNode.next = node
                zeroNode = zeroNode.next!!
            } else {
                zeroNode.`val` += node.`val`
            }
        }
        prev.next = null
        return head
    }
}
