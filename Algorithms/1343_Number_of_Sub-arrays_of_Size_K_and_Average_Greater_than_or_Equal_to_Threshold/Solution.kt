class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var acc = (0 until k).map { arr[it] }.sum()
        var res = if (acc.avg(k) >= threshold.toDouble()) 1 else 0
        for (i in k until arr.size) {
            acc += arr[i] - arr[i - k]
            if (acc.avg(k) >= threshold.toDouble()) {
                ++res
            }
        }
        return res
    }

    private fun Int.avg(k: Int) = this.toDouble() / k.toDouble()
}
