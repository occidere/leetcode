object Solution {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums.groupMapReduce(n => n)(_ => 1)(_ + _)
    .foldLeft(scala.collection.mutable.PriorityQueue[(Int, Int)]()(Ordering.by(_._2)))(_ += _)
    .dequeueAll
    .take(k)
    .map(_._1)
    .toArray
}