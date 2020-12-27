/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> = if (root == null) emptyList() else {
        val list = ArrayList<Pair<Int, Node>>().also { it += Pair(0, root) }

        var i = 0
        while (i < list.size) {
            list += list[i++].run {
                this.second.children.map { Pair(this.first + 1, it!!) }
            }
        }

        list.groupBy(Pair<Int, Node>::first) { it.second.`val` }.values.toList()
    }
}