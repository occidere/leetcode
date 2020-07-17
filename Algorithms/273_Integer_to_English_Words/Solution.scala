object Solution {
  def numberToWords(num: Int): String = if (num == 0) "Zero" else {
    val suffix = Array("", "Thousand", "Million", "Billion")
    val over20 = Map[Int, String](20 -> "Twenty", 30 -> "Thirty", 40 -> "Forty", 50 -> "Fifty", 60 -> "Sixty", 70 -> "Seventy", 80 -> "Eighty", 90 -> "Ninety")
    val under20 = Array("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")

    num.toString.reverse.grouped(3).map(_.reverse).zipWithIndex.filter(_._1.toInt != 0).map(kv => {
      List(
        if (kv._1.length == 3 && kv._1(0) != '0') under20(kv._1(0) - '0') + " Hundred" else "", {
          val rest = (if (kv._1.length == 3) kv._1.tail else kv._1).toInt
          if (rest == 0) "" else if (rest < 20) under20(rest) else over20(rest - (rest % 10)) + " " + under20(rest % 10)
        }
      ).mkString(" ").trim + s" ${suffix(kv._2)}"
    }).toList.reverse.mkString(" ").trim
  }
}