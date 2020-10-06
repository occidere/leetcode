object Solution {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val m = mat.length
    val n = mat.head.length
    val inRange = (r: Int, c: Int) => 0 <= r && r < m && 0 <= c && c < n

    val res = Array.fill(m)(Array.fill(n)(0))
    for (i <- Range(0, m); j <- Range(0, n)) {
      res(i)(j) = (for (r <- Range(i - K, i + K + 1); c <- Range(j - K, j + K + 1)) yield {
        if (inRange(r, c)) mat(r)(c) else 0
      }).sum
    }

    res
  }
}