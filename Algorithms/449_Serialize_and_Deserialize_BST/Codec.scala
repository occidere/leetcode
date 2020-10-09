import scala.collection.mutable

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 * var value: Int = _value
 * var left: TreeNode = null
 * var right: TreeNode = null
 * }
 */

class Codec {
  // Encodes a list of strings to a single string.
  def serialize(root: TreeNode): String = {
    val serialized = mutable.ListBuffer[String]()

    def preorder(node: TreeNode): Unit = {
      if (node != null) {
        serialized += s"${if (node.left == null) ""  else node.left.value}:${node.value}:${if (node.right == null) ""  else node.right.value}"
        preorder(node.left)
        preorder(node.right)
      }
    }

    preorder(root)
    serialized.mkString("_")
  }

  // Decodes a single string to a list of strings.
  def deserialize(data: String): TreeNode = if (data.isEmpty) null else {
    val q = data.split("_")
      .map(_.split(":", -1))
      .foldLeft(mutable.Queue[Array[String]]())(_.enqueue(_))
    val root = new TreeNode(q.head(1).toInt)

    def build(node: TreeNode): Unit = {
      if (node != null) {
        val next = q.dequeue()
        if (next(0).nonEmpty) node.left = new TreeNode(next(0).toInt)
        if (next(2).nonEmpty) node.right = new TreeNode(next(2).toInt)
        build(node.left)
        build(node.right)
      }
    }

    build(root)
    root
  }
}