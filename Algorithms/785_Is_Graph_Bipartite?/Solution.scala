import scala.collection.mutable

object Solution {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val board = graph.zipWithIndex
      .flatMap(xs => xs._1.flatMap(x => Array((xs._2, x))))
      .groupMapReduce(_._1)(x => Array(x._2))(_ ++: _)
      .withDefaultValue(Array[Int]())
    val nodes = mutable.ArrayBuffer.fill(graph.length)(0)

    def dfs(cur: Int, curVal: Int = 1): Boolean = {
      nodes(cur) = curVal
      for (next <- board(cur)) {
        if (nodes(next) == curVal ||
          (nodes(next) == 0 && !dfs(next, -curVal))) return false
      }
      true
    }

    for (i <- graph.indices) {
      if (nodes(i) == 0 && !dfs(i)) return false
    }
    true
  }
}