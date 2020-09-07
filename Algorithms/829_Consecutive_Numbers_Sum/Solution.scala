import scala.annotation.tailrec

object Solution {
  def consecutiveNumbersSum(N: Int): Int = {
    var count = 1

    @tailrec
    def find(left: Int, right: Int, acc: Int): Unit = if (0 < left && left <= right) {
      if (acc <= N) {
        if (acc == N) count += 1
        find(left - 1, right, acc + left - 1)
      } else find(left, right - 1, acc - right)
    }

    val l = N >> 1
    val r = l + 1
    find(l, r, l + r)

    count
  }
}