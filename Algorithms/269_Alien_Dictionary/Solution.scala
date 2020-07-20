import scala.collection.mutable

object Solution {

  def alienOrder(words: Array[String]): String = {
    val graph = words.flatMap(_.toSet).distinct.map((_, mutable.ListBuffer[Char]())).toMap
    val inDegree = graph.map(kv => (kv._1, 0)).to(mutable.Map)

    for (i <- Range(1, words.length)) {
      val w1 = words(i - 1)
      val w2 = words(i)

      if (w1.startsWith(w2) && w1.length > w2.length) return ""

      val diffChars = w1.zip(w2).dropWhile(chars => chars._1 == chars._2)
      if (diffChars.nonEmpty) {
        graph(diffChars.head._1).addOne(diffChars.head._2)
        inDegree(diffChars.head._2) += 1
      }
    }

    val ordered = mutable.ListBuffer[Char]()
    val q = inDegree.filter(_._2 == 0).keys.to(mutable.Queue)
    while (q.nonEmpty) {
      val curChar = q.dequeue()
      ordered += curChar
      q ++= graph(curChar).map(nextChar => {
        inDegree(nextChar) -= 1
        (nextChar, inDegree(nextChar))
      }).filter(_._2 == 0).map(_._1)
    }

    if (ordered.length < inDegree.size) "" else ordered.mkString("")
  }
}