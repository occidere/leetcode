class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n < 0) {
            return false
        } else if (n == 1) {
            return true
        }

        var k = 4L
        while (true) {
            if (k == n.toLong()) {
                return true
            } else if (k > n.toLong()) {
                return false
            }
            k = k.shl(2)
        }
    }
}
