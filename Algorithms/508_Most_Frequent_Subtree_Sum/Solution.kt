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
    fun findFrequentTreeSum(root: TreeNode?): IntArray = mutableMapOf<Int, Int>()
        .also { root.postOrder(it) }
        .map { it.key to it.value }
        .sortedByDescending { it.second }
        .run { filter { it.second == first().second } }
        .map { it.first }
        .toIntArray()

    private fun TreeNode?.postOrder(subTreeSums: MutableMap<Int, Int>): Int =
        if (this == null) 0 else (`val` + left.postOrder(subTreeSums) + right.postOrder(subTreeSums)).also {
            subTreeSums[it] = subTreeSums.getOrDefault(it, 0) + 1
        }
}
