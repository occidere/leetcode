import scala.collection.mutable.ListBuffer

object Solution {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = if (arr.length <= 2) true else {
    val sorted = arr.sorted
    val diffs = sorted.zip(sorted.tail).map(xs => xs._1 - xs._2)
    diffs.zip(diffs.tail)
      .foldLeft(ListBuffer[Int]())((lb, xs) => {lb ++= xs._1 :: xs._2 :: Nil; lb})
      .distinct
      .length == 1
  }
}