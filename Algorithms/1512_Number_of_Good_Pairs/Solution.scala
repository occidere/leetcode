object Solution {
  def numIdenticalPairs(nums: Array[Int]): Int = nums
    .map((_, 1))
    .groupMapReduce(_._1)(_._2)(_ + _)
    .map(kv => kv._2 * (kv._2 - 1) >> 1)
    .sum
}