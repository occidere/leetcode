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
 * @since 2022-09-06
 */
class Solution {
    private var cnt = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        root?.dfs(targetSum.toLong())
        return cnt
    }

    private fun TreeNode.dfs(targetSum: Long) {
        left?.dfs(targetSum)
        right?.dfs(targetSum)
        calc(targetSum, `val`.toLong())
    }

    private fun TreeNode.calc(targetSum: Long, acc: Long) {
        if (acc == targetSum) {
            ++cnt
        }
        left?.calc(targetSum, acc + left!!.`val`)
        right?.calc(targetSum, acc + right!!.`val`)
    }
}
