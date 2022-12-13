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
 * @since 2022-12-12
 */
class Solution {
    fun findSecondMinimumValue(root: TreeNode): Int {
        val vals = mutableSetOf<Int>()
        fun TreeNode.dfs() {
            vals.add(`val`)
            left?.dfs()
            right?.dfs()
        }
        root.dfs()
        return vals.sorted()
            .drop(1)
            .firstOrNull() ?: -1
    }
}
