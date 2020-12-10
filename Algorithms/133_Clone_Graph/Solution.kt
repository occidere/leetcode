/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {

    fun cloneGraph(node: Node?): Node? = if (node == null) node else {
        val nodeMap = mutableMapOf<Int, Node>()
        val neighborMap = mutableMapOf<Int, MutableSet<Int>>()

        fun dfs(cur: Node) {
            val v = cur.`val`
            if (!nodeMap.containsKey(v)) {
                nodeMap[v] = Node(v)
                cur.neighbors.forEach { next ->
                    next?.also {
                        neighborMap.merge(v, mutableSetOf(it.`val`)) { acc, l -> acc += l; acc }
                        dfs(it)
                    }
                }
            }
        }

        dfs(node)

        neighborMap.forEach { kv ->
            nodeMap[kv.key]!!.neighbors = kv.value
                    .map { nodeMap[it] }
                    .toList()
                    .let { arrayListOf<Node?>().apply { this.addAll(it) } }
        }

        nodeMap[node.`val`]
    }
}