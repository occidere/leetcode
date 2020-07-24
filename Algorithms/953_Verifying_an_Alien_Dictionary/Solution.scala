import scala.collection.mutable

object Solution {
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val graph = words.flatten.map(c => (c, mutable.ListBuffer[Char]())).toMap

    for (i <- Range(1, words.length)) {
      val w = (words(i - 1), words(i))
      if (w._1.length > w._2.length && w._1.startsWith(w._2)) return false
      Iterator.range(0, Math.min(w._1.length, w._2.length))
        .dropWhile(j => w._1(j) == w._2(j))
        .take(1)
        .foreach(x => graph(w._1(x)) += w._2(x))
    }

    val orders = order.zipWithIndex.toMap
    for (kv <- graph.filter(_._2.nonEmpty)) {
      val cur = orders(kv._1)
      for (next <- kv._2.map(orders(_))) {
        if (cur >= next) return false
      }
    }

    true
  }
}