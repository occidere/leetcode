object Solution {
  def kLengthApart(nums: Array[Int], k: Int): Boolean = {
    val arr = nums.zipWithIndex
      .filter(_._1 == 1)
      .map(_._2)
    arr.isEmpty || !arr.zip(arr.tail).exists(x => x._2 - x._1 - 1 < k)
  }
}