import scala.collection.mutable.ArrayBuffer

object Solution {
  def subdomainVisits(cpdomains: Array[String]): List[String] = cpdomains.map(_.split(" "))
    .map(x => {
      val domains = x(1).split('.').reverse
      (domains.tail.foldLeft(ArrayBuffer(domains.head))((ds, d) => ds += d + "." + ds.last), x(0).toInt)
    })
    .flatMap(x => x._1.map(d => (d, x._2)))
    .groupMapReduce(_._1)(_._2)(_ + _)
    .map(x => x._2 + " " + x._1)
    .toList
}