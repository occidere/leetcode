// Ref: https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation
class Solution {
    fun mirrorReflection(p: Int, q: Int): Int {
        var (m, n) = q to p
        while (m % 2 == 0 && n % 2 == 0) {
            m = m.shr(1)
            n = n.shr(1)
        }
        return if (m % 2 == 0 && n % 2 == 1) {
            0
        } else if (m % 2 == 1 && n % 2 == 1) {
            1
        } else if (m % 2 == 1 && n % 2 == 0) {
            2
        } else {
            -1
        }
    }
}
