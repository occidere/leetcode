import scala.collection.mutable

object Solution {
  def findItinerary(tickets: List[List[String]]): List[String] = {
    val graph = tickets.groupMapReduce(_.head)(x => List(x.last))(_ ++ _)
      .view
      .mapValues(mutable.PriorityQueue[String]()(Ordering.String.reverse).addAll(_))
      .to(mutable.Map)
      .withDefaultValue(mutable.PriorityQueue())
    val trace = mutable.ListBuffer[String]()

    def move(cur: String = "JFK"): Unit = {
      Iterator.continually(graph(cur))
        .takeWhile(_.nonEmpty)
        .foreach(pq => move(pq.dequeue()))
      trace += cur
    }

    move()
    trace.reverse.result()
  }
}