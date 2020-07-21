import Utils._

import scala.collection.mutable
import scala.util.matching.Regex

object Utils {
  private val charRegex: Regex = "[a-zA-Z]".r
  private val numRegex: Regex = "[0-9]".r

  implicit class StringBuilderUtils(val buf: StringBuilder) {
    def popStr: String = (buf.result(), buf.clear())._1
    def splitNumberAndChars: Iterable[String] = Iterable(charRegex.findAllIn(buf).mkString(""), numRegex.findAllIn(buf.popStr).mkString(""))
  }
}

object Solution {
  def decodeString(s: String): String = {
    val buf = new StringBuilder()
    val stk = mutable.Stack[String]()
    for (c <- s) c match {
      case '[' => stk.pushAll(buf.splitNumberAndChars).push("[")
      case ']' =>
        stk.push(buf.popStr)
        stk.push(Iterator.continually(stk.pop())
          .takeWhile(pop => stk.nonEmpty && pop != "[")
          .reduceLeft((li, str) => str ++ li)
          .mkString("") * stk.pop().toInt)
      case _ => buf += c
    }
    stk.popAll().mkString("") + buf.popStr
  }
}
