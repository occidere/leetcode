class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        var (a, b, cnt) = Triple(num1, num2, 0)
        while (a > 0 && b > 0) {
            if (a >= b) {
                a -= b
            } else {
                b -= a
            }
            ++cnt
        }
        return cnt
    }
}
