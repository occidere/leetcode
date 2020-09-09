object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val d = Array.fill(amount + 1)(0x3f3f3f3f)
    d(0) = 0

    for (coin <- coins; i <- Range(coin, amount + 1)) d(i) = d(i) min d(i - coin) + 1

    if (d(amount) < 0x3f3f3f3f) d(amount) else -1
  }
}