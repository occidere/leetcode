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
class CBTInserter(private val root: TreeNode) {

    private val insertTargets = mutableListOf(root)

    fun insert(`val`: Int): Int {
        arrangeTargets()

        val target = getTarget()
        if (target.left == null) {
            target.left = TreeNode(`val`)
            addFirst(target)
        } else {
            target.right = TreeNode(`val`)
            addAllChildrenOf(target)
        }
        return target.`val`
    }

    fun get_root() = root

    private fun arrangeTargets() {
        while (insertTargets.isNotEmpty()) {
            val node = getTarget()
            if (node.left != null && node.right != null) {
                addAllChildrenOf(node)
            } else {
                addFirst(node)
                break
            }
        }
    }

    private fun getTarget() = insertTargets.removeAt(0)

    private fun addFirst(node: TreeNode) {
        insertTargets.add(0, node)
    }

    private fun addAllChildrenOf(node: TreeNode) {
        insertTargets += node.left!!
        insertTargets += node.right!!
    }
}
