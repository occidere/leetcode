import scala.collection.mutable

object Solution {
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    val (dx, dy) = Array(-1, 1, 0, 0, -1, -1, 1, 1) -> Array(0, 0, -1, 1, -1, 1, -1, 1)
    val (m, n) = grid.length -> grid.head.length
    val canMove = (x: Int, y: Int, w: Int) =>
      (0 <= x && x < m) && (0 <= y && y < n) && (grid(x)(y) == 0 || grid(x)(y) < w)

    if (grid(0)(0) == 0) {
      grid(0)(0) = -1
      val q = mutable.Queue[(Int, Int, Int)]((0, 0, -1))
      while (q.nonEmpty) {
        val (x, y, w) = q.dequeue()
        for (i <- 0 to 7) {
          val (ax, ay, aw) = (x + dx(i), y + dy(i), w - 1)
          if (canMove(ax, ay, aw)) {
            grid(ax)(ay) = aw
            q.enqueue((ax, ay, aw))
          }
        }
      }
    }
    if (grid(m - 1)(n - 1) == 0) -1 else -grid(m - 1)(n - 1)
  }
}