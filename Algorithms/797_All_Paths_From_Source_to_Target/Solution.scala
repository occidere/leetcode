import scala.collection.mutable

object Solution {
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
    val n = graph.length
    val visit = Array.fill(n)(false)
    val paths = mutable.ListBuffer[List[Int]]()

    def find(cur: Int, trace: mutable.ListBuffer[Int]): Unit =
      if (cur == n - 1) paths += trace.toList
      else graph(cur).foreach(next => {
        if (!visit(next)) {
          visit(next) = true
          find(next, trace :+ next)
          visit(next) = false
        }
      })

    graph(0).foreach(next => {
      visit(next) = true
      find(next, mutable.ListBuffer(0, next))
      visit(next) = false
    })

    paths.toList
  }
}