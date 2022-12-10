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
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-04
 */
class Solution {
    private var total = 0L
    private var maxProd = 0L

    fun maxProduct(root: TreeNode): Int {
        root.calcTotalSum()
        root.dfs()
        return (maxProd % 1000000007).toInt()
    }

    private fun TreeNode.calcTotalSum() {
        total += `val`
        this.left?.calcTotalSum()
        this.right?.calcTotalSum()
    }

    private fun TreeNode.dfs(): Long {
        val leftSum = this.left?.dfs() ?: 0
        val rightSum = this.right?.dfs() ?: 0
        maxProd = max(
            maxProd, max(
                leftSum * (total - leftSum),
                rightSum * (total - rightSum)
            )
        )
        return `val` + leftSum + rightSum
    }
}
