object Solution {
  def findDuplicate(nums: Array[Int]): Int = {
    var slow = nums(0)
    var fast = nums(slow)

    while (slow != fast) {
      slow = nums(slow)
      fast = nums(nums(fast))
    }

    fast = 0
    while (slow != fast) {
      slow = nums(slow)
      fast = nums(fast)
    }
    slow
  }
}