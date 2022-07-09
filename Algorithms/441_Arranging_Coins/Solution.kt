class Solution {
    fun arrangeCoins(n: Int): Int {
        var (a, b) = 1L to 2L
        var k = 2L
        while (true) {
            if (n in a..b) {
                return (k - 1).toInt()
            }
            a += k++
            b += k
        }
        return 0
    }
}
