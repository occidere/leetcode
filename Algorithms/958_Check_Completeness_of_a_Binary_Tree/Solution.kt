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
    fun isCompleteTree(root: TreeNode): Boolean {
        val (q, indexTree) = mutableListOf(root) to mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val node = q.removeAt(0)
            indexTree += node.`val`
            if (node.`val` != 0) {
                q.add(node.left ?: TreeNode(0))
                q.add(node.right ?: TreeNode(0))
            }
        }
        for (i in 1 until indexTree.size) {
            if (indexTree[i] != 0 && indexTree[i - 1] == 0) {
                return false
            }
        }
        return true
    }
}
