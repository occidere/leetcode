import scala.collection.mutable

object Utils {
  implicit class StringUtils(a: String) {
    def biDirectionalPairs(b: String)(d: Double): Seq[(String, Seq[(String, Double)])] = Seq(a -> Seq((b, d)), b -> Seq((a, 1.0 / d)))
  }
}

object Solution {
  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    import Utils._
    val visit = equations.flatten.map((_, false)).to(mutable.Map)
    val graph = equations.zip(values)
      .flatMap { case (xs: List[String], d: Double) => xs.head.biDirectionalPairs(xs.last)(d) }
      .groupMapReduce(_._1)(_._2)(_ ++ _)

    def dfs(cur: String, target: String, cost: Double = 1.0): Double = if (!graph.contains(cur)) -1.0 else if (cur == target) cost else {
      graph(cur).map { next =>
        if (visit(next._1)) -1.0
        else (visit(next._1) = true, dfs(next._1, target, cost * next._2), visit(next._1) = false)._2
      }.max
    }

    queries.map(q => (visit(q.head) = true, dfs(q.head, q.last), visit(q.head) = false)._2).toArray
  }
}