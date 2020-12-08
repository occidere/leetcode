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
    private val levelMap = mutableMapOf<TreeNode, Int>().withDefault { -1 }

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        postorder(root)
        return levelMap.map { it.value to it.key }
                .fold(sortedMapOf<Int, MutableList<Int>>(), { acc, p ->
                    if (!acc.containsKey(p.first)) acc[p.first] = mutableListOf()
                    acc[p.first]!! += p.second.`val`
                    acc
                }).values
                .toList()
    }

    private fun postorder(root: TreeNode?) {
        if (root != null) {
            val left = root.left.also { postorder(it) }
            val right = root.right.also { postorder(it) }
            levelMap[root] =
                    if (left == null && right == null) 0
                    else 1 + max(
                            if (left != null) levelMap[left]!! else -1,
                            if (right != null) levelMap[right]!! else -1
                    )
        }
    }
}