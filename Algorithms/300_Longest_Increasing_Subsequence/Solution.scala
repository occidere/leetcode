object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = if (nums.isEmpty) 0 else {
    val d = Array.fill(nums.length)(1)
    for (i <- Range(1, d.length); j <- Range(0, i + 1))
      if (nums(i) > nums(j) && d(i) < d(j) + 1) d(i) = d(j) + 1
    d.max
  }
}