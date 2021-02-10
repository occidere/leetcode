import scala.collection._

object Solution {
  def openLock(deadends: Array[String], target: String): Int = {
    var minCount = 0x3f3f3f3f
    val forbidden = deadends.foldLeft(mutable.Set[String]())(_ += _)
    val q = mutable.Queue[(String, Int)]()
    q.enqueue("0000" -> 0)

    def isPossible(pair: (String, Int)): Boolean = !forbidden.contains(pair._1) && pair._2 < minCount

    def enqueueIfPossible(pair: (String, Int)) = if (isPossible(pair)) q.enqueue(pair)

    while (q.nonEmpty) {
      val p = q.dequeue()
      if (p._1 == target) {
        minCount = math.min(minCount, p._2)
      }
      if (isPossible(p)) {
        forbidden += p._1
        for (i <- 0 to 3) {
          enqueueIfPossible(getNextPair(p, i, 1))
          enqueueIfPossible(getNextPair(p, i, -1))
        }
      }
    }

    if (minCount == 0x3f3f3f3f) -1 else minCount
  }

  private def getNextPair(pair: (String, Int), i: Int, delta: Int): (String, Int) =
    s"${pair._1.take(i)}${getNextNum(pair._1(i), delta)}${pair._1.drop(i + 1)}" -> (pair._2 + 1)

  private def getNextNum(num: Char, delta: Int): String = ((num - '0' + delta + 10) % 10).toString
}