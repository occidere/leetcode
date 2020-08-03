import scala.collection.mutable.ArrayBuffer

object Utils {
  implicit class StringUtils(s: String) {
    def isAppendableTo(buf: Iterable[String], maxWidth: Int): Boolean = buf.map(_.length).sum + s.length + buf.size <= maxWidth
  }

  implicit class IterableUtils(buf: Iterable[String]) {
    def mkSentence(maxWidth: Int)(leftOnly: Boolean): String = {
      val s = buf.mkString(" ")
      val lack = maxWidth - s.length
      if (leftOnly) s + (" " * lack) else {
        val len = buf.size - 1
        val paddings = ArrayBuffer.fill(len)(" ")
        for (i <- Range(0, lack)) paddings(i % len) += " "
        buf.zip[String](paddings :+ "").map(x => x._1 + x._2).mkString("")
      }
    }
  }
}

object Solution {

  import Utils._

  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val sentences = List.newBuilder[String]
    val buf = ArrayBuffer[String]()
    lazy val popAsSentence = (leftOnly: Boolean) => (buf.mkSentence(maxWidth)(leftOnly), buf.clear())._1

    for (w <- words) {
      if (!w.isAppendableTo(buf, maxWidth)) sentences += popAsSentence(buf.size == 1)
      buf += w
    }

    sentences += popAsSentence(true)
    sentences.result()
  }
}