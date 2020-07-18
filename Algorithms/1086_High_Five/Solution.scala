object Solution {
  def highFive(items: Array[Array[Int]]): Array[Array[Int]] = items
    .sortBy(a => -a(1))
    .groupMap(_ (0))(_ (1))
    .map(xs => (xs._1, xs._2.take(5)))
    .map(xs => Array(xs._1, xs._2.sum / 5))
    .toArray
    .sortBy(_ (0))
}