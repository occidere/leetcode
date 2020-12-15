import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: Node?): String = if (root == null) "" else {
        val nodeMap = mutableMapOf<Node, Int>().also { it[root] = 0 }
        val serialized = mutableListOf(root.toString(nodeMap[root]!!, -1))
        val q = LinkedList<Node>().also { it.add(root) }

        var nodeId = 1
        while (q.isNotEmpty()) {
            val parent = q.removeFirst()
            val parentNodeId = nodeMap[parent]!!
            for (child in parent.children) {
                if (child != null) {
                    nodeMap[child] = nodeId
                    serialized += child.toString(nodeId, parentNodeId)
                    q.add(child)
                    ++nodeId
                }
            }
        }

        serialized.joinToString(" ")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): Node? = if (data.isBlank()) null else {
        val deserialized = data.split(" ")
        val nodeMap = mutableMapOf<Int, Node>().also { it[0] = Node(deserialized.first().destruct()[2]) }

        for (d in deserialized.drop(1)) {
            val (parentNodeId, nodeId, nodeVal) = d.destruct()
            val node = Node(nodeVal)
            nodeMap[nodeId] = node
            nodeMap[parentNodeId]!!.children = nodeMap[parentNodeId]!!.children + node
        }

        nodeMap[0]
    }

    private fun Node.toString(nodeId: Int, parentNodeId: Int): String = "${parentNodeId}:$nodeId:${this.`val`}"

    private fun String.destruct(): List<Int> = this.split(":").map { it.toInt() }
}