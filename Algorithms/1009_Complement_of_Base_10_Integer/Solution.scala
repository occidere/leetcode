object Solution {
  def bitwiseComplement(N: Int): Int = if (N == 0) 1 else {
    var i = 1
    while (i <= N) i <<= 1
    N ^ (i - 1)
  }
}