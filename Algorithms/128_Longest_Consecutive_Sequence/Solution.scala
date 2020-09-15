import scala.annotation.tailrec
import scala.collection.mutable

object Solution {
  def longestConsecutive(nums: Array[Int]): Int = if (nums.isEmpty) 0 else {
    val maxLens = nums.foldLeft(mutable.Map[Int, Int]())((m, x) => {
      m(x) = 1
      m
    })

    @tailrec
    def find(cur: Int, len: Int): Int = {
      val next = cur - 1
      if (!maxLens.contains(next)) len
      else if (maxLens(next) >= len + 1) maxLens(next)
      else {
        maxLens(next) = len + 1
        find(next, len + 1)
      }
    }

    nums.map(x => find(x, 1)).max
  }
}