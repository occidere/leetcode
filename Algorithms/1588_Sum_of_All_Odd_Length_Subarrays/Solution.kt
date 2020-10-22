class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var ans = 0
        val size = arr.size

        val d = Array(size) { IntArray(size) }
        for (i in arr.indices) {
            ans += arr[i]
            d[0][i] = arr[i] + if (i != 0) d[0][i - 1] else 0
        }

        for (range in 3..size step 2) {
            for (i in 0..(size - range)) {
                ans += d[0][i + range - 1] - if (i != 0) d[0][i - 1] else 0
            }
        }

        return ans
    }
}