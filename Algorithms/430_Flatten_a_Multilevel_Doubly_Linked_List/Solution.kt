/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {
    private val stk = java.util.Stack<Node?>()

    fun flatten(root: Node?): Node? {
        if (root != null) {
            if (root.child != null) {
                stk.push(root.next)
                root.next = flatten(root.child!!)
                root.next?.prev = root
                root.child = null
            }
            if (root.next != null) {
                flatten(root.next!!)
            } else if (stk.isNotEmpty()) {
                root.next = stk.pop()
                root.next?.prev = root
            }
        }
        return root
    }
}
