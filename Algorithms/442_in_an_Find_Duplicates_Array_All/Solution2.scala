object Solution {
  def findDuplicates(nums: Array[Int]): List[Int] = nums.indices.map(x => {
    val idx = Math.abs(nums(x)) - 1
    if (nums(idx) <= 0) idx + 1 else {
      nums(idx) *= -1
      0
    }
  }).foldLeft(List.empty[Int])((xs, x) => if (x != 0) xs :+ x else xs)
}