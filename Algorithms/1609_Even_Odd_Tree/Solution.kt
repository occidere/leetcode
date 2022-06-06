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
    private val valuesByLevel = mutableMapOf<Int, Int>()

    fun isEvenOddTree(root: TreeNode?, level: Int = 0): Boolean = root == null
            || root.`val`.putAndCheckIsValid(level)
            && isEvenOddTree(root.left, level + 1)
            && isEvenOddTree(root.right, level + 1)

    private fun Int.putAndCheckIsValid(level: Int) = if ((level % 2 + this % 2) == 1) {
        if (valuesByLevel.contains(level)) {
            ((level % 2 == 0 && valuesByLevel[level]!! < this) || (level % 2 == 1 && valuesByLevel[level]!! > this))
                .also { valuesByLevel[level] = this }
        } else {
            valuesByLevel[level] = this
            true
        }
    } else {
        false
    }
}
