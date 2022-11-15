import kotlin.math.min
import kotlin.math.pow

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
 * @since 2022-11-15
 */
class Solution {
    fun countNodes(root: TreeNode?) = if (root == null) 0 else {
        val h = root.calcLevel()
        var (left, right) = 2.0.pow((h - 1).toDouble())
            .toInt()
            .let { it to it.shl(1) }
        while (left <= right) {
            val mid = (left + right).shr(1)
            if (root.hasNode(getPath(mid))) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        min(left, right)
    }

    private fun TreeNode.calcLevel(): Int {
        var head: TreeNode? = this
        var level = 0
        while (head != null) {
            ++level
            head = head.left
        }
        return level
    }

    private fun getPath(leaf: Int): List<Int> {
        val path = mutableListOf<Int>()
        var nodeNum = leaf
        while (nodeNum != 0) {
            path.add(nodeNum % 2) // 0: from left / 1: from right
            nodeNum = nodeNum.shr(1)
        }
        return path.reversed().drop(1)
    }

    private fun TreeNode.hasNode(path: List<Int>): Boolean {
        var head: TreeNode? = this
        for (p in path) {
            head = if (p == 0) head?.left else head?.right
        }
        return head != null
    }
}
