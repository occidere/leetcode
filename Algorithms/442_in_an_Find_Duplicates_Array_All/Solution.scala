import scala.collection.mutable.ListBuffer

object Solution {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    val dup = new ListBuffer[Int]()

    for (i <- nums.indices) {
      val idx = Math.abs(nums(i))
      if (nums(idx - 1) > 0) nums(idx - 1) *= -1
      else dup += Math.abs(nums(i))
    }

    dup.result()
  }
}