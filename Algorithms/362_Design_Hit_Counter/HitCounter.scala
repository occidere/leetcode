import scala.collection.mutable

/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-07-22
 */
class HitCounter(interval: Int = 300) {
  private val hits = mutable.Map[Int, Int](-interval -> 0)
  private val timestamps = mutable.ArrayBuffer[Int](-interval)
  private val hitsAt = (t: Int) => hits(timestamps(upperBound(t) - 1))

  @scala.annotation.tailrec
  private def upperBound(t: Int, front: Int = 0, rear: Int = timestamps.size): Int = if (front >= rear) rear else {
    val mid = (front + rear) >> 1
    if (timestamps(mid) <= t) upperBound(t, mid + 1, rear) else upperBound(t, front, mid)
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity). */
  def hit(timestamp: Int) {
    hits(timestamp) = 1 + (if (!hits.contains(timestamp)) hits(timestamps.last) else hits(timestamp))
    timestamps += timestamp
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity). */
  def getHits(timestamp: Int): Int = hitsAt(timestamp + 1) - hitsAt(timestamp - interval)
}
