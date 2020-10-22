import scala.annotation.tailrec

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 * def get(index: Int): Int = {}
 * }
 */

object Solution {
  @tailrec
  def search(reader: ArrayReader, target: Int, left: Int = 0, right: Int = 9999): Int = {
    if (left > right) -1
    else {
      val mid = (left + right) >> 1
      if (reader.get(mid) == target) mid
      else if (reader.get(mid) > target) search(reader, target, left, mid - 1)
      else search(reader, target, mid + 1, right)
    }
  }
}