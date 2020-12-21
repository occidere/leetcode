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
    fun balanceBST(root: TreeNode?): TreeNode? = if (root == null) null else build(root.inorder())

    private fun TreeNode?.inorder(): Array<Int> = if (this == null) emptyArray() else
        this.left.inorder() + arrayOf(this.`val`) + this.right.inorder()

    private fun build(values: Array<Int>): TreeNode? = if (values.isEmpty()) null else {
        val len = values.size
        val mid = len shr 1
        TreeNode(values[mid]).also {
            build(values.sliceArray(0 until mid))?.apply { it.left = this }
            build(values.sliceArray(mid + 1 until len))?.apply { it.right = this }
        }
    }
}