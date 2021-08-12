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
    fun increasingBST(root: TreeNode?, tail: TreeNode? = null): TreeNode? {
//        println("root = ${root?.`val`}, tail = ${tail?.`val`}")
        if (root == null) {
            return tail
        }
        val head = increasingBST(root.left, root)
        root.left = null
        root.right = increasingBST(root.right, tail)
        return head
    }
}
