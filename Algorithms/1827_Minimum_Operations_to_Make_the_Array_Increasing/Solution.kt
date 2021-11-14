class Solution {
    fun minOperations(nums: IntArray) = nums.drop(1)
        .fold(nums.first() to 0) { acc, n ->
            with(if (acc.first < n) 0 else kotlin.math.abs(acc.first + 1 - n)) {
                if (this == 0) n to acc.second else Pair(acc.first + 1, acc.second + this)
            }
        }.second
}
