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
    fun averageOfSubtree(root: TreeNode): Int {
        val nodeMap = mutableMapOf<TreeNode, Pair<Int, Int>/* acc, cnt */>()
        fun TreeNode?.inorder(): Pair<Int, Int> = if (this == null) 0 to 0 else {
            val (lp, rp) = left.inorder() to right.inorder()
            nodeMap[this] =  `val` + lp.first + rp.first to 1 + lp.second + rp.second
            nodeMap[this]!!
        }
        nodeMap[root] = root.inorder()
        return nodeMap.entries.count { (it.value.first / it.value.second) == it.key.`val` }
    }
}
