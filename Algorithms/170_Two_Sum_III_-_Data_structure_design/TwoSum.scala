import scala.collection.mutable

/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-10-08
 */
class TwoSum() {
  private val cache = mutable.Set[Long]()
  private val nums = mutable.ArrayBuffer[Int]()

  def add(number: Int) {
    if (nums.nonEmpty) nums.foreach(num => if (!cache.contains(num + number)) cache += (num + number))
    nums += number
  }

  def find(value: Int): Boolean = cache.contains(value)
}