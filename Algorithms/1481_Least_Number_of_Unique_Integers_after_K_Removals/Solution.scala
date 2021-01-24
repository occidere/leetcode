object Solution {
  def findLeastNumOfUniqueInts(arr: Array[Int], k: Int): Int = {
    var r = k
    arr.groupMapReduce(x => x)(_ => 1)(_ + _)
      .toList
      .sortBy(_._2)
      .dropWhile(x => {r -= x._2; r >= 0})
      .size
  }
}