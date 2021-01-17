object Utils {

  implicit class IntArrayUtils(arr: Array[Int]) {
    def flip: Array[Int] = arr.map(_ ^ 1)

    def toDecimal: Int = arr.zipWithIndex
      .map(kv => math.pow(2, arr.length - kv._2 - 1) * kv._1)
      .map(_.toInt)
      .sum
  }

}

object Solution {

  import Utils._

  def matrixScore(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A(0).length

    for (i <- 0 until m) {
      if (A(i)(0) == 0) {
        A(i) = A(i).flip
      }
    }

    for (i <- 1 until n) {
      val binCount = (0 until m)
        .map(j => if (A(j)(i) == 0) (1, 0) else (0, 1))
        .reduce((p1, p2) => (p1._1 + p2._1, p1._2 + p2._2))
      if (binCount._1 > binCount._2) {
        for (j <- 0 until m) {
          A(j)(i) ^= 1
        }
      }
    }

    A.map(_.toDecimal).sum
  }
}