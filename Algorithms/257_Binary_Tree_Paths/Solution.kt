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
    fun binaryTreePaths(root: TreeNode, path: List<Int> = listOf(root.`val`)): List<String> =
        if (root.isLeaf()) listOf(path.joinToString("->"))
        else root.left.doOrEmpty(path) + root.right.doOrEmpty(path)

    private fun TreeNode.isLeaf() = left == null && right == null

    private fun TreeNode?.doOrEmpty(path: List<Int>) =
        this?.let { binaryTreePaths(it, path + listOf(it.`val`)) } ?: listOf()
}
