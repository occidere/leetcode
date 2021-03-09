import java.util.*

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
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? = root?.let {
        if (d == 1) {
            TreeNode(v).apply { left = root }
        } else {
            val prevNodes = mutableListOf<TreeNode>()
            val q = LinkedList<Pair<Int, TreeNode>>().apply { add(Pair(1, root)) }
            while (q.isNotEmpty()) {
                val (depth, node) = q.poll()
                if (depth == d - 1) {
                    prevNodes += node
                } else if (depth < d) {
                    node.left?.also { q += depth + 1 to it }
                    node.right?.also { q += depth + 1 to it }
                } else {
                    break
                }
            }

            for (prev in prevNodes) {
                TreeNode(v).apply {
                    left = prev.left
                    prev.left = this
                }
                TreeNode(v).apply {
                    right = prev.right
                    prev.right = this
                }
            }
            root
        }
    } ?: TreeNode(v)
}