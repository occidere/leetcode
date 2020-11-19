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
        val nodes = arrayListOf<Node>()
        val nodeIdx = mutableMapOf<Node, Int>()

        while (head != null) {
            nodes.add(head)
            nodeIdx[head] = n++
            head = head.next
        }

        val copied = Array<Node?>(n) { null }
        fun Node.tryCopyNode(): Boolean {
            val curIdx = nodeIdx.getValue(this)
            return if (copied[curIdx] != null) false else {
                copied[curIdx] = Node(this.`val`)
                true
            }
        }

        fun Node.followRandom() {
            val randomNode = this.random
            if (randomNode != null && randomNode.tryCopyNode()) {
                randomNode.followRandom()
            }
        }

        for (originNode in nodes) {
            originNode.tryCopyNode()
            originNode.followRandom()
        }

        for (i in 0 until n) {
            copied[i]!!.random = copied[nodeIdx.getValue(nodes[i])]
            if (i < n - 1) {
                copied[i]!!.next = copied[i + 1]
            }
        }

        copied[0]
    }
}