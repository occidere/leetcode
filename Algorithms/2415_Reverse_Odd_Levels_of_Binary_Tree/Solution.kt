/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-25
 */
class Solution {
    fun reverseOddLevels(root: TreeNode): TreeNode {
        var i = 0
        val arr = mutableListOf(root)
        while (i < arr.size) {
            if (arr[i].left != null) {
                arr.add(arr[i].left!!)
                arr.add(arr[i].right!!)
            }
            ++i
        }

        i = 0 // level
        while (true) {
            var l = 1.shl(i + 1) - 1
            val r = l + 1.shl(i + 1)
            if (arr.size <= l) {
                break
            } else if (i % 2 == 0) {
                arr.reverse(l, r)
            }
            for (j in 1.shl(i) - 1 until l) {
                arr[j].left = arr[l++]
                arr[j].right = arr[l++]
            }
            ++i
        }

        return root
    }
    
    
    private fun MutableList<TreeNode>.reverse(l: Int, r: Int) {
        val half = (r - l).shr(1)
        for (i in 0 until half) {
            val tmp = this[l + i]
            this[l + i] = this[r - i - 1]
            this[r - i - 1] = tmp
        }
    }
}
