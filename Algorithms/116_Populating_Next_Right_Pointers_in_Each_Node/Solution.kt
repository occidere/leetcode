/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
//        return root?.bfs()
        return root?.dfs()
    }

    // Mine
    private fun Node.bfs(): Node {
        if (this.left != null && this.right != null) {
            val q = mutableListOf(Pair(this.right!!, 1))
            var prev = Pair(this.left!!, 1)
            prev.first.left?.also { q += Pair(it, 2) }
            prev.first.right?.also { q += Pair(it, 2) }

            while (q.isNotEmpty()) {
                val cur = q.removeAt(0)
                if (prev.second == cur.second) {
                    prev.first.next = cur.first
                }
                cur.first.left?.also { q += Pair(it, cur.second + 1) }
                cur.first.right?.also { q += Pair(it, cur.second + 1) }

                prev = cur
            }
        }
        return this
    }

    // Follow-up solution from discuss
    private fun Node.dfs(nextNode: Node? = null): Node {
        next = nextNode
        left?.dfs(right)
        right?.dfs(next?.left)
        return this
    }
}
