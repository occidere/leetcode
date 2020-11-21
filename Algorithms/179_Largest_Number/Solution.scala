object Solution {
  def largestNumber(nums: Array[Int]): String = nums.map(_.toString)
    .sortWith((a, b) => a + b > b + a)
    .mkString("")
    .dropWhile(_ == '0') match {
    case "" => "0"
    case s => s
  }
}