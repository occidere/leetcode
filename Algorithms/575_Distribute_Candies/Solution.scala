object Solution {
  def distributeCandies(candyType: Array[Int]): Int =
    scala.math.min(candyType.distinct.length, candyType.length >> 1)
}