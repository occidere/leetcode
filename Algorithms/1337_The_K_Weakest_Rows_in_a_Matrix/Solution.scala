object Solution {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = mat.zipWithIndex
    .map(x => x._1.sum -> x._2)
    .sortWith((x, y) => if (x._1 == y._1) x._2 < y._2 else x._1 < y._1)
    .map(_._2)
    .take(k)

  def main(args: Array[String]): Unit = {
    println(kWeakestRows(
      Array(Array(1, 1, 0, 0, 0),
        Array(1, 1, 1, 1, 0),
        Array(1, 0, 0, 0, 0),
        Array(1, 1, 0, 0, 0),
        Array(1, 1, 1, 1, 1)),
      3
    ).mkString(", "))
  }
}