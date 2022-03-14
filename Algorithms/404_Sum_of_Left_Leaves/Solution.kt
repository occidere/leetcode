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
    fun sumOfLeftLeaves(root: TreeNode, isLeft: Boolean = false): Int {
        if (root.left == null && root.right == null) {
            return if (isLeft) root.`val` else 0
        }
        var acc = 0
        if (root.left != null) {
            acc += sumOfLeftLeaves(root.left!!, true)
        }
        if (root.right != null) {
            acc += sumOfLeftLeaves(root.right!!, false)
        }
        return acc
    }
}
