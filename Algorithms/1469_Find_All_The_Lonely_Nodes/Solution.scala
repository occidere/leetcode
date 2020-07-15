/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def getLonelyNodes(root: TreeNode): List[Int] = {
    val lonelyNodes = List.newBuilder[Int]
    if (root.left != null) lonelyNodes.addAll((if (root.right == null) List(root.left.value) else List()) ++ getLonelyNodes(root.left))
    if (root.right != null) lonelyNodes.addAll((if (root.left == null) List(root.right.value) else List()) ++ getLonelyNodes(root.right))
    lonelyNodes.result()
  }
}