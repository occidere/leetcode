/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
object Solution {
  def reorderList(head: ListNode): Unit = if (head != null) {
    var h = head
    val nodes = Iterator.continually(h)
      .takeWhile(_ != null)
      .map(node => (node, h = h.next)._1)
      .toList
    val len = (nodes.length / 2) + nodes.length % 2
    h = head
    nodes.zip(nodes.reverse)
      .take(len)
      .flatMap(xs => List(xs._1, xs._2))
      .tail
      .takeWhile(_ != h)
      .foreach(x => {
        h.next = x
        h = x
      })
    h.next = null
  }
}