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
  def averageOfLevels(root: TreeNode): Array[Double] = {
    var p = 0
    val nodes = mutable.ArrayBuffer[(Int, TreeNode)](0 -> root)
    while (p < nodes.length) {
      val (lvl, node) = nodes(p)
      if (node.left != null) nodes += (lvl + 1 -> node.left)
      if (node.right != null) nodes += (lvl + 1 -> node.right)
      p += 1
    }

    nodes.groupMap(_._1)(_._2.value.toDouble)
      .toArray
      .sortBy(_._1)
      .map(xs => xs._2.sum / xs._2.length)
  }
}