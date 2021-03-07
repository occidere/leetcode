import scala.collection.mutable

object Solution {
  def mostVisitedPattern(username: Array[String], timestamp: Array[Int], website: Array[String]): List[String] =
    username.indices
      .map(i => (username(i), timestamp(i), website(i))).groupBy(_._1) // group by username
      .map(_._2.sortBy(_._2)) // order by time asc
      .flatMap(xs => mkSeqs(xs.map(_._3))).groupBy(xs => xs) // to 3-seq list and group by 3-seq
      .map(xs => xs._1 -> xs._2.size).toList // to (3-seq, frequency) list
      .sortWith((a, b) => if (a._2 == b._2) a._1 < b._1 else a._2 > b._2) // order by freq desc, 3-seq asc
      .head._1 // limit 1
      .split(" ").toList

  private def mkSeqs(xs: IndexedSeq[String]): List[String] = {
    val (seqs, len) = (mutable.ListBuffer[String](), xs.length)
    for (i <- 0 until len; j <- i + 1 until len; k <- j + 1 until len) {
      seqs += s"${xs(i)} ${xs(j)} ${xs(k)}"
    }
    seqs.toList.distinct
  }
}