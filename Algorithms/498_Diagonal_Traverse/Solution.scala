object Utils {
  val RIGHT: (Int, Int) = (0, 1)
  val DOWN: (Int, Int) = (1, 0)
  val RIGHT_UP: (Int, Int) = (-1, 1)
  val LEFT_DOWN: (Int, Int) = (1, -1)
  var MATRIX: Array[Array[Int]] = Array()

  implicit class TupleUtils(x: (Int, Int)) {
    def isEven: Boolean = (x._1 + x._2) % 2 == 0
    def isValid: Boolean = (0 <= x._1 && x._1 < MATRIX.length) && (0 <= x._2 && x._2 < MATRIX(0).length)
    def add(y: (Int, Int)): (Int, Int) = (x._1 + y._1, x._2 + y._2)
    def getNextValidOrElse(ds: (Int, Int)*)(default: (Int, Int)): (Int, Int) = ds.find(y => x.add(y).isValid).getOrElse(default)
  }
}

object Solution {
  def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = if (matrix.isEmpty) Array() else {
    import Utils._
    MATRIX = matrix

    var p = (0, 0)
    Iterator.range(0, matrix.length * matrix(0).length).map(_ => {
      val v = matrix(p._1)(p._2)
      p = p.add(if (p.isEven) p.getNextValidOrElse(RIGHT_UP, RIGHT)(DOWN) else p.getNextValidOrElse(LEFT_DOWN, DOWN)(RIGHT))
      v
    }).toArray
  }
}