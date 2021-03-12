object Solution {
  def hasAllCodes(s: String, k: Int): Boolean = {
    val bins = (k to s.length).map(i => s.substring(i - k, i)).toSet
    for (i <- 0 to (math.pow(2, k) - 1).toInt) {
      if (!bins.contains(s"%${k}s".format(i.toBinaryString).replace(" ", "0"))) {
        return false
      }
    }
    true
  }
}