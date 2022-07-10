class Solution {
    fun specialArray(nums: IntArray) = nums.sorted()
        .run {
            var limit = 0
            for (n in 0..last()) {
                while (limit < size && this[limit] < n) {
                    ++limit
                }
                if (size - limit == n) {
                    return n
                }
            }
            -1
        }
}
