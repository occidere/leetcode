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
    private val leafPaths = mutableListOf<List<Int>>()
    private var nodeId = 0

    fun countPairs(root: TreeNode, distance: Int): Int {
        root.`val` = nodeId++
        root.dfs(listOf(root.`val`))
        var ans = 0
        for (i in leafPaths.indices) {
            for (j in i + 1 until leafPaths.size) {
                if (leafPaths[i].getDist(leafPaths[j]) <= distance) {
                    ++ans
                }
            }
        }
        return ans
    }

    private fun TreeNode.dfs(path: List<Int> = listOf()) {
        if (left == null && right == null) {
            leafPaths += path.toList()
        } else {
            if (left != null) {
                left!!.`val` = nodeId++
                left!!.dfs(path + listOf(left!!.`val`))
            }
            if (right != null) {
                right!!.`val` = nodeId++
                right!!.dfs(path + listOf(right!!.`val`))
            }
        }
    }

    private fun List<Int>.getDist(other: List<Int>): Int {
        val minSize = kotlin.math.min(size, other.size)
        for (i in 0 until minSize) {
            if (this[i] != other[i]) {
                return size - i + other.size - i
            }
        }
        return size - minSize + other.size - minSize
    }
}
