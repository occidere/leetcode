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

// Ref: https://leetcode.com/problems/delete-node-in-a-bst/discuss/93298/Iterative-solution-in-Java-O(h)-time-and-O(1)-space/193018
class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        var parent: TreeNode? = null
        var child = root
        while (child != null && child.`val` != key) {
            parent = child
            child = if (child.`val` > key) child.left else child.right
        }

        return if (parent == null) {
            root.deleteRootNode()
        } else {
            if (parent.left == child) {
                parent.left = child.deleteRootNode()
            } else {
                parent.right = child.deleteRootNode()
            }
            root
        }
    }

    private fun TreeNode?.deleteRootNode(): TreeNode? =
        if (this == null) {
            null
        } else if (this.left != null && this.right != null) {
            right!!.getMinNode().left = left
            right
        } else {
            left ?: right
        }

    private fun TreeNode.getMinNode(): TreeNode = left?.getMinNode() ?: this
}
/*
[5,3,6,2,4,null,7]
3
[5,3,6,2,4,null,7]
0
[5,3,6,2,4,null,7]
7
[5,3,6,2,4,null,7]
3
[5,3,6,2,4,null,7]
5
[5,3,6,2,4,null,7]
2
[5,3,6,2,4,null,7]
4
[]
0
[5,3,6,2,4,null,7]
10
[0]
0
[4,null,7,6,8,5,null,null,9]
7
[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]
33
 */
