import scala.collection.mutable

object Solution {
  def findPairs(nums: Array[Int], k: Int): Int = {
    val sortedNums = nums.sorted
    var left = 0
    var right = 1

    val pairs = mutable.Set[(Int, Int)]()
    while (left < right && right < sortedNums.length) {
      val diff = sortedNums(right) - sortedNums(left)
      if (diff == k) {
        pairs += (sortedNums(left) -> sortedNums(right))
        right += 1
      } else if (diff > k) {
        left += 1
        if (left == right) right += 1
      } else right += 1
    }

    pairs.size
  }
}