object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int = if (left > right) -1
    else {
      val mid = (left + right) >> 1
      if (nums(mid) == target) mid
      else if (nums(mid) < target) binarySearch(mid + 1, right)
      else binarySearch(left, mid - 1)
    }
    binarySearch(0, nums.length - 1)
  }
}