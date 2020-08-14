import scala.collection.mutable

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */
object Solution {
  implicit class TreeNodeUtils(node: TreeNode) {
    def children() = List(node.left, node.right)
  }

  def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
    val deleteSet = to_delete.toSet
    val forest = mutable.ListBuffer[TreeNode]()

    def dfs(cur: TreeNode): Boolean = {
      if (cur.left != null && dfs(cur.left)) cur.left = null
      if (cur.right != null && dfs(cur.right)) cur.right = null

      if (deleteSet.contains(cur.value)) (forest ++= cur.children, true)._2
      else false
    }

    (if (dfs(root)) forest ++ root.children() else forest :+ root)
      .filter(_ != null)
      .distinctBy(_.value)
      .result()
  }
}