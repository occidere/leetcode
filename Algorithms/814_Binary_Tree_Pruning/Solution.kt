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
    fun pruneTree(root: TreeNode?): TreeNode? = root?.let {
        it.prune().run {
            if (this == 0) null else it
        }
    }

    private fun TreeNode?.prune(): Int = if (this == null) 0 else this.`val` +
            this.left.prune().also { if (it == 0) this.left = null } +
            this.right.prune().also { if (it == 0) this.right = null }
}