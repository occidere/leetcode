/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 * var value: Int = _value
 * var children: List[Node] = List()
 * }
 */

object Solution {
  def findRoot(tree: List[Node]): Node = {
    val rootNum = tree.map(parent => parent.value - parent.children.map(_.value).sum).sum
    tree.find(_.value == rootNum).head
  }
}