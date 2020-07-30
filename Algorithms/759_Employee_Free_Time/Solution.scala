import scala.collection.mutable

/**
 * Definition for an Interval.
 * class Interval(var _start: Int, var _end: Int) {
 * var start: Int = _start
 * var end: Int = _end
 * }
 */

object Utils {

  implicit class IntervalUtils(prev: Interval) {
    def isOverlappedWith(next: Interval): Boolean = !(prev._end < next.start || next._end < prev.start)
    def createMergedIntervalWith(next: Interval): Interval = new Interval(Math.min(prev.start, next.start), Math.max(prev._end, next._end))
    def createFreeInterval(next: Interval): Interval = new Interval(prev._end, next.start)
  }

  implicit class ArrayBufferUtils[A](arr: mutable.ArrayBuffer[A]) {
    def changeLastTo(newVal: A): Unit = arr(arr.length - 1) = newVal
  }
}

object Solution {
  def employeeFreeTime(schedule: List[List[Interval]]): List[Interval] = {
    import Utils._
    val intervals = schedule.flatten.sortWith((a, b) => if (a.start == b.start) a._end < b._end else a.start < b.start)
    val workingTimes = mutable.ArrayBuffer(intervals.head)

    for (next <- intervals.tail) {
      if (workingTimes.last isOverlappedWith next) workingTimes changeLastTo (workingTimes.last createMergedIntervalWith next)
      else workingTimes += next
    }

    Iterator.range(1, workingTimes.length)
      .map(i => workingTimes(i - 1) createFreeInterval workingTimes(i))
      .toList
  }
}