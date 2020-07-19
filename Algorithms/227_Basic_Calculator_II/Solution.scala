import scala.collection.mutable

object Solution {
  def calculate(s: String): Int = {
    def foldMulDiv(dq: mutable.ArrayDeque[String])(e: String)(f: (Int, Int) => Int): Unit = {
      dq.removeLast()
      dq.update(dq.length - 1, f(dq(dq.length - 1).toInt, e.toInt).toString)
    }

    lazy val isOperator: String => Boolean = (s: String) => Set("+", "-", "*", "/") contains s
    val numbers = """[0-9]+""".r.findAllIn(s).toArray
    val operators = """[\+\-\*/]""".r.findAllIn(s).toArray

    if (operators.isEmpty) numbers.head.toInt else {
      val expr = numbers.zip(operators :+ " ").flatMap(x => List(x._1, x._2)).dropRight(1)
      val dq = mutable.ArrayDeque(expr.head)
      for (e <- expr.tail) {
        if (isOperator(e)) dq += e else dq.last match {
          case "*" => foldMulDiv(dq)(e)(_ * _)
          case "/" => foldMulDiv(dq)(e)(_ / _)
          case _ => dq += e
        }
      }

      var acc = dq.head.toInt
      for (i <- Range(1, dq.length, 2)) {
        acc += dq(i + 1).toInt * (if (dq(i) == "-") -1 else 1)
      }
      acc
    }
  }
}