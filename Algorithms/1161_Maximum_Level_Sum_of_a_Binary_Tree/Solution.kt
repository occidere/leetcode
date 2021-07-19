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
    private val levelSum = mutableMapOf<Int, Int>()

    fun maxLevelSum(root: TreeNode?, level: Int = 1): Int {
        if (root != null) {
            levelSum.putIfAbsent(level, 0)
            levelSum.merge(level, root.`val`, Integer::sum)
            maxLevelSum(root.left, level + 1)
            maxLevelSum(root.right, level + 1)
        }

        return if (level != 1) 0 else levelSum.map { Pair(it.key, it.value) }
                .sortedWith(Comparator { x, y -> if (x.second == y.second) x.first - y.first else y.second - x.second })
                .first()
                .first
    }
}
