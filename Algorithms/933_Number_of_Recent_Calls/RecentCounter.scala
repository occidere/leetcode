import scala.collection.mutable

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2020. 10. 01.
 */
class RecentCounter {
  private val counter = mutable.Queue[Int]()

  def ping(t: Int): Int = {
    counter += t
    while (t - 3000 > counter.head) counter.dequeue()
    counter.size
  }
}