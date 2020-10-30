object Solution {
  def checkArithmeticSubarrays(nums: Array[Int], l: Array[Int], r: Array[Int]): List[Boolean] = l.zip(r)
    .map(xs => nums.slice(xs._1, xs._2 + 1).sorted)
    .map(xs => xs.zip(xs.slice(1, xs.length))
      .map(ys => ys._1 - ys._2)
      .distinct
      .length == 1
    ).toList
}