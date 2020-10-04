object Utils {
  implicit class ArrayUtils(a: Array[Int]) {
    def isCoveredBy(b: Array[Int]): Boolean = b(0) <= a(0) && a(1) <= b(1)
  }
}

object Solution {
  import Utils._
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    val itvs = intervals.sortBy(a => a(1) - a(0))
    itvs.length - Iterator.range(1, itvs.length)
      .map(i => Iterator.range(i, itvs.length).exists(j => itvs(i - 1).isCoveredBy(itvs(j))))
      .count(x => x)
  }
}