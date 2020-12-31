import scala.collection.mutable

object Solution {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val stk = mutable.Stack[Int]()

    var i = 0
    for (element <- pushed) {
      stk.push(element)
      while (stk.nonEmpty && stk.top == popped(i)) {
        stk.pop()
        i += 1
      }
    }

    stk.isEmpty
  }
}