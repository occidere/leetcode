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
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-14
 */
class Solution {
    fun pseudoPalindromicPaths(root: TreeNode, visit: Int = 1.shl(root.`val`)): Int =
        if (root.left == null && root.right == null) {
            if (visit.isPseudoPalindromic()) 1 else 0
        } else root.left.travel(visit) + root.right.travel(visit)

    private fun TreeNode?.travel(visit: Int) =
        this?.let { pseudoPalindromicPaths(it, visit.xor(1.shl(it.`val`))) } ?: 0

    private fun Int.isPseudoPalindromic() =
        this == 0 || Integer.toBinaryString(this).count { it == '1' } == 1
}
