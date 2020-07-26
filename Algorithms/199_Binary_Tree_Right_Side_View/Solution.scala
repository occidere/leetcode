import scala.collection.mutable.ArrayBuffer

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */
object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    preorder(root).toList
  }

  def preorder(root: TreeNode, depth: Int = 0, view: ArrayBuffer[Int] = ArrayBuffer[Int]()): ArrayBuffer[Int] = {
    if (root != null) {
      if (depth < view.length) view(depth) = root.value
      else view += root.value
      preorder(root.left, depth + 1, view)
      preorder(root.right, depth + 1, view)
    }
    view
  }
}