/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    /*
    Time: O(N)
    Space: O(N)
     */
//    fun connect(root: Node?, level: Int = 0, lastByLevel: MutableMap<Int, Node> = mutableMapOf()): Node? {
//        if (root != null) {
//            connect(root.right, level + 1, lastByLevel)
//            if (lastByLevel.containsKey(level)) {
//                root.next = lastByLevel[level]
//            }
//            lastByLevel[level] = root
//            connect(root.left, level + 1, lastByLevel)
//        }
//        return root
//    }

    /*
    Follow-up: 각 level 마다 left child, right child 를 연결 시도. 처리 완료후 현재 노드의 next 로 이동 가능하면 이동해서 반복, 불가능하면 left child 로 이동 (dummyNextForChild.next)
    Time: O(N)
    Space: O(1)
     */
    fun connect(root: Node?): Node? {
        if (root != null) {
            var curParent: Node? = root
            val dummyNextForChild = Node(0)
            var ptr = dummyNextForChild

            while (curParent != null) {
                if (curParent.left != null) {
                    ptr.next = curParent.left
                    ptr = ptr.next!!
                }
                if (curParent.right != null) {
                    ptr.next = curParent.right
                    ptr = ptr.next!!
                }

                if (curParent.next != null) {
                    curParent = curParent.next
                } else {
                    curParent = dummyNextForChild.next
                    dummyNextForChild.next = null
                    ptr = dummyNextForChild
                }
            }
        }
        return root
    }
}
