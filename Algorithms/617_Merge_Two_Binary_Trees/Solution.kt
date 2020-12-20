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
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? = if (t1 == null && t2 == null) null else {
        val merged = TreeNode(0).apply {
            t1?.also { this.`val` += it.`val` }
            t2?.also { this.`val` += it.`val` }
        }
        preorder(t1, t2, merged)
        merged
    }

    private fun preorder(n1: TreeNode?, n2: TreeNode?, m: TreeNode) {
        if (n1 == null && n2 == null) {
            return
        }

        if (n1 != null) {
            n1.left?.apply {
                if (m.left == null) m.left = TreeNode(0)
                m.left!!.`val` += this.`val`
            }
            n1.right?.apply {
                if (m.right == null) m.right = TreeNode(0)
                m.right!!.`val` += this.`val`
            }
        }

        if (n2 != null) {
            n2.left?.apply {
                if (m.left == null) m.left = TreeNode(0)
                m.left!!.`val` += this.`val`
            }
            n2.right?.apply {
                if (m.right == null) m.right = TreeNode(0)
                m.right!!.`val` += this.`val`
            }
        }

        if (m.left != null) preorder(n1?.left, n2?.left, m.left!!)
        if (m.right != null) preorder(n1?.right, n2?.right, m.right!!)
    }
}