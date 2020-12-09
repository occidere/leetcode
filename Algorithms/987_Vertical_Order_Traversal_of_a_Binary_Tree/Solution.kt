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
    private val verticalMap = sortedMapOf<Int, MutableList<Pair<Int, Int>>>()

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        preorder(root)
        return verticalMap.values
                .map {
                    it.sortedWith(Comparator { a, b ->
                        if (a.first == b.first) a.second.compareTo(b.second)
                        else b.first.compareTo(a.first)
                    })
                }
                .map { it.map { p -> p.second } }
    }

    private fun preorder(node: TreeNode?, x: Int = 0, y: Int = 0) {
        if (node != null) {
            verticalMap.merge(x, mutableListOf(Pair(y, node.`val`))) { acc, l -> acc += l; acc }
            preorder(node.left, x - 1, y - 1)
            preorder(node.right, x + 1, y - 1)
        }
    }
}