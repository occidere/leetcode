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
    private var maxLen = 0

    fun longestZigZag(root: TreeNode): Int {
        root.left?.traversal(1, 0, false)
        root.right?.traversal(0, 1, true)
        return maxLen
    }

    private fun TreeNode.traversal(leftSum: Int, rightSum: Int, nextIsLeft: Boolean) {
        maxLen = kotlin.math.max(maxLen, rightSum + leftSum)
        if (nextIsLeft) {
            left?.traversal(leftSum + 1, rightSum, false)
            right?.traversal(0, 1, true)
        } else {
            left?.traversal(1, 0, false)
            right?.traversal(leftSum, rightSum + 1, true)
        }
    }
}
