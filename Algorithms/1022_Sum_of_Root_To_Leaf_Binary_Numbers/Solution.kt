import kotlin.math.max

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
    fun sumRootToLeaf(root: TreeNode?, bStr: String = "${root!!.`val`}"): Int = max(
        ((root!!.left?.let { sumRootToLeaf(root.left, bStr + root.left!!.`val`) } ?: 0)
                + (root.right?.let { sumRootToLeaf(root.right, bStr + root.right!!.`val`) } ?: 0)),
        Integer.parseInt(bStr, 2)
    )
}
