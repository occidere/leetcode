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
    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        root?.left?.apply { root.left = trimBST(root.left, low, high) }
        root?.right?.apply { root.right = trimBST(root.right, low, high) }
        return when {
            root?.`val` in low..high -> root
            root?.left?.`val` in low..high -> root?.left
            root?.right?.`val` in low..high -> root?.right
            else -> null
        }
    }
}