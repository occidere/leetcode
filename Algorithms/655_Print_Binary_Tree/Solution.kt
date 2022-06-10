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
    fun printTree(root: TreeNode): List<List<String>> {
        val level = root.getLevel()
        val arr = Array(level) { Array(1.shl(level) - 1) { "" } }
        root.preorder(arr, 0 to (1.shl(level) - 1).shr(1), 1.shl(level - 2))
        return arr.map { it.toList() }
    }

    private fun TreeNode.getLevel(acc: Int = 1): Int =
        kotlin.math.max(left?.getLevel(acc + 1) ?: acc, right?.getLevel(acc + 1) ?: acc)

    private fun TreeNode.preorder(arr: Array<Array<String>>, cur: Pair<Int, Int>, dy: Int) {
        arr[cur.first][cur.second] = "$`val`"
        left?.preorder(arr, cur.first + 1 to cur.second - dy, dy.shr(1))
        right?.preorder(arr, cur.first + 1 to cur.second + dy, dy.shr(1))
    }
}
