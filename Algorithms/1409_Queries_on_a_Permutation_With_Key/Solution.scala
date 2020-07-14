object Solution {
  def processQueries(queries: Array[Int], m: Int): Array[Int] = {
    val p = List.range(1, m + 1).toBuffer
    Array.range(0, queries.length).map(i => (p.takeWhile(_ != queries(i)).distinct.length, p.insert(0, queries(i)))._1)
  }
}