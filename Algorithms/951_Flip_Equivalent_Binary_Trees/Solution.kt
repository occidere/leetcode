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
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        val (q1, q2) = mutableListOf(root1) to mutableListOf(root2)
        while (q1.isNotEmpty() || q2.isNotEmpty()) {
            val (node1, node2) = q1.pollOrNull() to q2.pollOrNull()
            if (node1 == null && node2 == null) {
                continue
            } else if (!node1.equalTo(node2)) {
                return false
            }

            val (left1, left2) = node1?.left to node2?.left
            val (right1, right2) = node1?.right to node2?.right
            if (left1.equalTo(left2) && right1.equalTo(right2)) {
                q1.addAll(listOf(left1, right1))
                q2.addAll(listOf(left2, right2))
            } else {
                q1.addAll(listOf(left1, right1))
                q2.addAll(listOf(right2, left2))
            }
        }
        return true
    }

    private fun MutableList<TreeNode?>.pollOrNull() = if (isEmpty()) null else removeAt(0)

    private fun TreeNode?.equalTo(other: TreeNode?) = this?.`val` == other?.`val`
}
