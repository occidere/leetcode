import scala.collection.mutable

object Solution {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val maxHeap = mutable.PriorityQueue[Int](nums.take(k): _*)(Ordering.Int)
    val freq = nums.take(k)
      .foldLeft(mutable.Map[Int, Int]().withDefaultValue(0))((m, x) => {
        m(x) += 1
        m
      })

    maxHeap.head +: Iterator.range(k, nums.length)
      .map(i => {
        freq(nums(i)) += 1
        freq(nums(i - k)) -= 1
        maxHeap.enqueue(nums(i))

        Iterator.continually(maxHeap)
          .takeWhile(pq => freq(pq.head) == 0)
          .foreach(_.dequeue)

        maxHeap.head
      }).toArray
  }
}