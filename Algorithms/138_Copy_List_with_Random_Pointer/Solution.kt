/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? = if (node == null) null else {
        var n = 0
        var head = node
        val nodeIdx = mutableMapOf<Node, Int>()
        val nodes = Array<Node?>(1000) { null }
        while (head != null) {
            nodeIdx[head] = n
            nodes[n++] = head
            head = head.next
        }

        val copied = Array<Node?>(n) { null }
        fun copyNode(curNode: Node): Boolean {
            val curIdx = nodeIdx.getValue(curNode)
            return if (copied[curIdx] == null) {
                copied[curIdx] = Node(curNode.`val`)
                true
            } else false
        }

        fun followRandom(curNode: Node) {
            val randomNode = curNode.random
            if (randomNode != null) {
                if (copyNode(randomNode)) {
                    followRandom(randomNode)
                }
            }
        }

        for (i in 0 until n) {
            copyNode(nodes[i]!!)
            followRandom(nodes[i]!!)
        }

        for (i in 0 until n) {
            copied[i]!!.random = if (nodes[i]?.random == null) null else copied[nodeIdx.getValue(nodes[i]!!.random!!)]
            if (i < n - 1) {
                copied[i]!!.next = copied[i + 1]
            }
        }

        copied[0]
    }
}
