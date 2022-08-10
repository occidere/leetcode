/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-10
 */
class Solution {
    fun evaluateTree(root: TreeNode): Boolean = when (root.`val`) {
        0 -> false
        1 -> true
        2 -> evaluateTree(root.left!!) || evaluateTree(root.right!!)
        else -> evaluateTree(root.left!!) && evaluateTree(root.right!!)
    }
}
