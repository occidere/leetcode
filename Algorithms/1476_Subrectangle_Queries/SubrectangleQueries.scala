import scala.collection.mutable.ListBuffer

class SubrectangleQueries(_rectangle: Array[Array[Int]]) {

  private var changes: ListBuffer[(Int, Int, Int, Int, Int)] = ListBuffer()

  def updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
    changes.addOne((row1, col1, row2, col2, newValue))
  }

  def getValue(row: Int, col: Int): Int = {
    for ((r1, c1, r2, c2, v) <- changes.reverse) {
      if ((r1 <= row && row <= r2) && (c1 <= col && col <= c2)) {
        return v
      }
    }
    _rectangle(row)(col)
  }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * var obj = new SubrectangleQueries(rectangle)
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue)
 * var param_2 = obj.getValue(row,col)
 */