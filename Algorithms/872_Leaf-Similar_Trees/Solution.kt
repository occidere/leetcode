/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-02
 *
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
    private val leaves1 = mutableListOf<Int>()
    private val leaves2 = mutableListOf<Int>()

    fun leafSimilar(root1: TreeNode, root2: TreeNode) =
        (root1.preorder(leaves1) to root2.preorder(leaves2)).run {
            leaves1.size == leaves2.size && leaves1.zip(leaves2).all { (x, y) -> x == y }
        }

    private fun TreeNode.preorder(leaves: MutableList<Int>) {
        if (left == null && right == null) {
            leaves.add(`val`)
            return
        }
        if (left != null) {
            left!!.preorder(leaves)
        }
        if (right != null) {
            right!!.preorder(leaves)
        }
    }
}
