object Solution {
  def maxDistance(arrays: List[List[Int]]): Int = {
    val minMax = arrays.map(xs => Array(xs.head, if (xs.length == 1) xs.head else xs.last)).toArray
    var maxDist = -10000
    for (i <- minMax.indices; j <- minMax.indices) {
      if (i != j) maxDist = math.max(maxDist, math.abs(minMax(i)(0) - minMax(j)(1)))
    }
    maxDist
  }
}