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
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val q = mutableListOf(Triple(root, 0, 1))
        val group = mutableMapOf<Int, MutableList<Triple<TreeNode?, Int, Int>>>()

        while (q.isNotEmpty()) {
            val (cur, level, idx) = q.removeAt(0)
            group.putIfAbsent(level, mutableListOf())
            group[level]!!.add(Triple(cur, level, idx))

            if (cur != null) {
                q += Triple(cur.left, level + 1, idx.shl(1))
                q += Triple(cur.right, level + 1, idx.shl(1) + 1)
            }
        }

        return group.values
            .map {
                val (firstNode, lastNode) = it.find { t -> t.first != null } to it.findLast { t -> t.first != null }
                if (firstNode != null && lastNode != null) {
                    lastNode.third - firstNode.third + 1
                } else {
                    0
                }
            }.max()!!
    }
}
