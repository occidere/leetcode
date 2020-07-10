/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 * var value: Int = _value
 * var children: List[Node] = List()
 * }
 */

object Solution {
  def cloneTree(root: Node): Node = if (root == null) null else new Node(root.value) {
    children = root.children.map(cloneTree)
  }
}