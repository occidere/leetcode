/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSubPath(head: ListNode, root: TreeNode): Boolean {
        return root.preorder(listOf(root.`val`), head.tsvValues())
    }

    private fun ListNode.tsvValues(): String {
        val vs = mutableListOf<Int>()
        var head: ListNode? = this
        while (head != null) {
            vs += head.`val`
            head = head.next
        }
        return vs.joinToString(",")
    }

    private fun TreeNode?.preorder(trace: List<Int>, csvTarget: String): Boolean = if (this == null) {
        trace.joinToString(",").contains(csvTarget)
    } else {
        left.preorder(
            trace + listOf(left?.`val` ?: 0), csvTarget
        ) || right.preorder(
            trace + listOf(right?.`val` ?: 0), csvTarget
        )
    }
}
