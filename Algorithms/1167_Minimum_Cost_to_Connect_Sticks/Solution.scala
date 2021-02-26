import scala.collection.mutable

object Solution {
  def connectSticks(sticks: Array[Int]): Int = {
    val minHeap = sticks.foldLeft(mutable.PriorityQueue[Int]())(_ += -_)
    var (acc, a) = 0 -> minHeap.dequeue()
    while (minHeap.nonEmpty) {
      a += minHeap.dequeue()
      acc += a
      minHeap.enqueue(a)
      a = minHeap.dequeue()
    }
    -acc
  }
}