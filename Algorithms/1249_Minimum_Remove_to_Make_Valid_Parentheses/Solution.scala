import scala.collection.mutable

object Solution {
  def minRemoveToMakeValid(s: String): String = {
    val cs = s.split("")
    val stk = mutable.Stack[Int]()
    for (i <- cs.indices) cs(i) match {
      case "(" => stk.push(i)
      case ")" => if (stk.isEmpty) cs(i) = "" else stk.pop()
      case _ =>
    }
    stk.popAll().foreach(cs(_) = "")
    cs.mkString("")
  }
}