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
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode {
        var preIdx = 0
        var postIdx = 0

        // root.val == post[postIdx] 성립 => 트리가 모두 완성되었다는 의미
        fun build(): TreeNode {
            val root = TreeNode(pre[preIdx++])
            if (root.`val` != post[postIdx]) {
                root.left = build()
            }
            if (root.`val` != post[postIdx]) {
                root.right = build()
            }
            ++postIdx
            return root
        }

        return build()
    }
}