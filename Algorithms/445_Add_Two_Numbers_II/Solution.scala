import scala.collection.mutable

object Utils {
  implicit class ListNodeUtils(var l: ListNode) {
    def toStack: mutable.Stack[Int] = Iterator.continually(l)
      .takeWhile(_ != null)
      .map(node => (node.x, l = node.next)._1)
      .foldLeft(mutable.Stack[Int]())((stk, x) => stk.push(x))
  }

  implicit class StackUtils(stk: mutable.Stack[Int]) {
    def toListNode: ListNode = {
      val l = new ListNode()
      var head = l
      Iterator.continually(stk)
        .takeWhile(_.nonEmpty)
        .foreach(x => {
          head.next = new ListNode(x.pop())
          head = head.next
        })
      l.next
    }
  }

}

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
object Solution {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    import Utils._
    val stk1 = l1.toStack
    val stk2 = l2.toStack
    val stk3 = mutable.Stack[Int]()

    var carry = 0
    do {
      val sum = (if (stk1.nonEmpty) stk1.pop() else 0) + (if (stk2.nonEmpty) stk2.pop() else 0) + carry
      if (sum >= 10) {
        carry = 1
        stk3.push(sum - 10)
      } else {
        carry = 0
        stk3.push(sum)
      }
    } while (stk1.nonEmpty || stk2.nonEmpty)
    if (carry > 0) stk3.push(carry)

    stk3.toListNode
  }
}