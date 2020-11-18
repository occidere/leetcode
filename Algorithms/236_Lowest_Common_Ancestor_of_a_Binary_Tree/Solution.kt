import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val (parentMap, levelMap) = root!!.createMetaMap()

        var pNode = p!!
        var qNode = q!!
        val raisePNode = levelMap.getValue(pNode) > levelMap.getValue(qNode)

        while (levelMap.getValue(pNode) != levelMap.getValue(qNode)) when {
            raisePNode -> pNode = parentMap.getValue(pNode)!!
            else -> qNode = parentMap.getValue(qNode)!!
        }

        while (pNode != qNode) {
            pNode = parentMap.getValue(pNode)!!
            qNode = parentMap.getValue(qNode)!!
        }

        return pNode
    }

    private fun TreeNode.createMetaMap(): Pair<Map<TreeNode, TreeNode?>, Map<TreeNode, Int>> {
        val parentMap = mutableMapOf<TreeNode, TreeNode?>()
        val levelMap = mutableMapOf<TreeNode, Int>()
        val q = ArrayDeque<TreeNode>()

        fun addNode(parent: TreeNode?, child: TreeNode) {
            parentMap[child] = parent
            levelMap[child] = if (parent == null) 0 else levelMap.getValue(parent) + 1
            q.add(child)
        }

        addNode(null, this)
        while (q.isNotEmpty()) {
            val cur = q.poll()
            if (cur.left != null) addNode(cur, cur.left!!)
            if (cur.right != null) addNode(cur, cur.right!!)
        }

        return Pair(parentMap, levelMap)
    }
}