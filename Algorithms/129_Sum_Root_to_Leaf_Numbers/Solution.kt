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
    fun sumNumbers(root: TreeNode, path: String = "${root.`val`}"): Int =
        if (root.isLeaf()) path.toInt()
        else root.left.travelWith(path) + root.right.travelWith(path)

    private fun TreeNode.isLeaf() = left == null && right == null

    private fun TreeNode?.travelWith(path: String) = this?.let { sumNumbers(it, path + it.`val`) } ?: 0
}
