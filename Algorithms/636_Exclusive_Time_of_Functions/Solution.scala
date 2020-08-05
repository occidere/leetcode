import scala.collection.mutable

object Solution {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val times = Array.fill(n)(0)
    val stk = mutable.Stack[Int]()

    var prev = 0
    for (log <- logs.map(_.split(":"))) {
      if (log(1) == "start") {
        if (stk.nonEmpty) times(stk.top) += log(2).toInt - prev
        stk.push(log(0).toInt)
        prev = log(2).toInt
      } else {
        times(stk.pop) += log(2).toInt - prev + 1
        prev = log(2).toInt + 1
      }
    }

    times
  }
}
