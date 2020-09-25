object Solution {
  def missingElement(nums: Array[Int], k: Int): Int = {
    var n = k
    for (i <- Range(1, nums.length)) {
      val d = nums(i) - nums(i - 1) - 1
      if (n > d) n -= d
      else return nums(i - 1) + n
    }
    nums.last + n
  }
}