import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class TimeMap {

  private case class TimeValue(value: String, timestamp: Int) {
    def <=(t: Int): Boolean = timestamp <= t
  }

  private val db = mutable.Map[String, ArrayBuffer[TimeValue]]().withDefaultValue(ArrayBuffer[TimeValue]())

  def set(key: String, value: String, timestamp: Int): Unit = db(key) = db(key) :+ TimeValue(value, timestamp)

  def get(key: String, timestamp: Int): String = if (!db.contains(key)) "" else {
    val values = TimeValue("", 0) +: db(key) :+ TimeValue("", 10000001)

    @scala.annotation.tailrec
    def upperBound(front: Int = 0, rear: Int = values.size - 1): Int = if (front >= rear) rear else {
      val mid = (front + rear) >> 1
      if (values(mid) <= timestamp) upperBound(mid + 1, rear) else upperBound(front, mid)
    }

    values(upperBound() - 1).value
  }
}