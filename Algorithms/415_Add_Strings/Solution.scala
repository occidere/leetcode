object Solution {
  def addStrings(num1: String, num2: String): String = {
    def add(nums: Seq[(Char, Char)], carry: Int = 0): String = {
      if (nums.isEmpty) return if (carry > 0) carry.toString else ""
      val sum = (nums.head._1 - '0' + nums.head._2 - '0' + carry).toString
      (if (sum.length == 2) sum.tail else sum) + add(nums.tail, if (sum.length == 2) 1 else 0)
    }

    val maxLen = Math.max(num1.length, num2.length)
    lazy val fixedSizeNum: String => String = (num: String) => num.reverse + "0" * (maxLen - num.length)
    add(fixedSizeNum(num1).zip(fixedSizeNum(num2))).reverse
  }
}