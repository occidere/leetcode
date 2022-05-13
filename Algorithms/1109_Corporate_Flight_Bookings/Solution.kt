/*
ref: https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C++Java-with-picture-O(n)
 */
class Solution {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val res = IntArray(n) { 0 }
        for ((a, b, c) in bookings) {
            res[a - 1] += c
            if (b < n) {
                res[b] -= c
            }
        }
        for (i in 1 until n) {
            res[i] += res[i - 1]
        }
        return res
    }
}
