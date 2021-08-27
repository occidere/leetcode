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
    fun subtreeWithAllDeepest(root: TreeNode): TreeNode {
        val (parents, nodes) = mutableMapOf<Int, TreeNode>() to mutableMapOf<Int, MutableList<TreeNode>>()

        fun TreeNode.dfs(level: Int = 0): Int {
            var deepestLevel = level
            nodes.putIfAbsent(level, mutableListOf())
            nodes[level]!! += this
            left?.also {
                parents[it.`val`] = this
                deepestLevel = max(deepestLevel, it.dfs(level + 1))
            }
            right?.also {
                parents[it.`val`] = this
                deepestLevel = max(deepestLevel, it.dfs(level + 1))
            }
            return deepestLevel
        }

        var leaves = nodes[root.dfs()]!!.toSet()
        while (leaves.size != 1) {
            leaves = leaves.map { parents[it.`val`]!! }.toSet()
        }
        return leaves.first()
    }
}