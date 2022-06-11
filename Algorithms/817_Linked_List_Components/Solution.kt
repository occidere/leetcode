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
    fun numComponents(head: ListNode, nums: IntArray): Int {
        val numSet = nums.toMutableSet()
        var node: ListNode? = head
        var (count, onComponent) = 0 to false
        while (node != null) {
            onComponent = numSet.remove(node.`val`).also {
                if (!it && onComponent) {
                    ++count
                }
            }
            node = node.next
        }
        return if (onComponent) count + 1 else count
    }
}
