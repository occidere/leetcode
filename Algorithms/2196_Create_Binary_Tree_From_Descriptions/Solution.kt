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
    fun createBinaryTree(descriptions: Array<IntArray>) = mutableMapOf<Int, TreeNode>().run {
        descriptions.forEach {
            val (parent, child, isLeft) = it
            this[parent] = getOrDefault(parent, TreeNode(parent)).also { parentNode ->
                this[child] = getOrDefault(child, TreeNode(child)).also { childNode ->
                    if (isLeft == 1) parentNode.left = childNode else parentNode.right = childNode
                }
            }
        }
        this[descriptions.map { it[0] }.toSet().subtract(descriptions.map { it[1] }.toSet()).first()]!!
    }
}
