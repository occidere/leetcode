object Utils {
  implicit class DivUtils(x: Int) {
    def toFizzBuzzNum: String = if (x % 15 == 0) "FizzBuzz" else if (x % 3 == 0) "Fizz" else if (x % 5 == 0) "Buzz" else x.toString
  }
}

object Solution {
  import Utils._
  def fizzBuzz(n: Int): List[String] = Iterator.range(1, n + 1).map(_.toFizzBuzzNum).toList
}