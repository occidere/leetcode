import scala.collection.mutable.ListBuffer

object Solution {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val graph = Array.fill(n) { ListBuffer[Int]() }
    for (e <- edges) {
      graph(e(0)) += e(1)
      graph(e(1)) += e(0)
    }

    val visit = Array.fill(n) { false }

    def dfs(cur: Int): Unit = {
      for (next <- graph(cur)) {
        if (!visit(next)) {
          visit(next) = true
          dfs(next)
        }
      }
    }

    var cnt = 0
    for (i <- 0 until n) {
      if (!visit(i)) {
        visit(i) = true
        dfs(i)
        cnt += 1
      }
    }

    cnt
  }
}
