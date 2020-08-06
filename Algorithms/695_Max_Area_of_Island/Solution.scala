object Utils {

  implicit class GridUtils(grid: Array[Array[Int]]) {
    private lazy val inRange = (x: Int, y: Int) => (0 <= x && x < grid.length) && (0 <= y && y < grid(0).length)

    def getIslandSize(x: Int, y: Int): Int = {
      var size = 1
      grid(x)(y) = 0

      def dfs(x: Int, y: Int): Unit = Array((-1, 0), (1, 0), (0, -1), (0, 1))
        .map(a => (a._1 + x, a._2 + y))
        .filter(a => inRange(a._1, a._2))
        .foreach(a => {
          if (grid(a._1)(a._2) == 1) {
            size += 1
            grid(a._1)(a._2) = 0
            dfs(a._1, a._2)
          }
        })

      dfs(x, y)
      size
    }
  }

}


object Solution {

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    import Utils._
    var maxSize = 0
    for (i <- grid.indices) {
      for (j <- grid(0).indices) {
        if (grid(i)(j) == 1) maxSize = Math.max(maxSize, grid.getIslandSize(i, j))
      }
    }
    maxSize
  }
}