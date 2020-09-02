object Solution {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val pq = matrix.flatten.foldLeft(scala.collection.mutable.PriorityQueue[Int]())(_ += -_)
    Iterator.range(0, k)
      .map(_ => -pq.dequeue())
      .toList
      .last
  }
}