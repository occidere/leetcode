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
 * @since 2022-10-22
 */
class Solution {
    fun getMinimumDifference(root: TreeNode?): Int {
        var (prev, minDiff) = -0x3f3f3f3f to 0x3f3f3f3f

        fun inorder(node: TreeNode?) {
            if (node != null) {
                inorder(node.left)
                minDiff = kotlin.math.min(minDiff, node.`val` - prev)
                prev = node.`val`
                inorder(node.right)
            }
        }
        
        inorder(root)
        return minDiff
    }
}
