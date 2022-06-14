class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val arr = mutableListOf<Int>()
        var acc = 0
        for (n in nums) {
            if (n == 0) {
                arr += if (acc != 0) listOf(acc, 0) else listOf(0)
                acc = 0
            } else {
                ++acc
            }
        }
        arr += acc

        return if (arr.size == 1) arr[0] - 1 else 1.until(arr.size - 1)
            .map { arr[it - 1] + arr[it + 1] }
            .max()!!
    }
}
