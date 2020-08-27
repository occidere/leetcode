object Solution {
  def findKthLargest(nums: Array[Int], k: Int): Int =
    nums.foldLeft(scala.collection.mutable.PriorityQueue[Int]())(_ += _).dequeueAll(k - 1)
}