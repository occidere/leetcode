import scala.collection.mutable

object Solution {
  def removeDuplicateLetters(s: String): String = {
    val lastPos = s.zipWithIndex.foldLeft(mutable.Map[Char, Int]())((m, xs) => {
      m(xs._1) = xs._2
      m
    })
    val stack: mutable.Stack[Char] = mutable.Stack[Char]()
    val seen = mutable.Set[Char]()

    for (i <- s.indices) {
      val c = s(i)
      if (!seen.contains(c)) {
        while (stack.nonEmpty && c < stack.top && i < lastPos(stack.top)) {
          seen.remove(stack.pop())
        }
        seen += c
        stack.push(c)
      }
    }

    stack.popAll().mkString("")
  }
}