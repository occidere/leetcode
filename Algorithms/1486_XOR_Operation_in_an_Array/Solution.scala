object Solution {
  def xorOperation(n: Int, start: Int): Int = LazyList range(0, n) map(i => start + 2 * i) reduce(_ ^ _)
}