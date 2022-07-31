/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-07-31
 */
class Solution {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        val limit = a + b + kotlin.math.max(x, forbidden.max()!!)
        val visit = forbidden.toSet().toMutableSet()
        val q = mutableListOf(Triple(0, false, 0))
        while (q.isNotEmpty()) {
            val (cur, fromBack, jumpCount) = q.removeAt(0)
            if (cur == x) {
                return jumpCount
            }

            val (forward, backward) = cur + a to cur - b
            if (forward <= limit && !visit.contains(forward)) {
                q.add(Triple(forward, false, jumpCount + 1))
                visit.add(forward)
            }
            if (0 < backward && !fromBack && !visit.contains(backward)) {
                q.add(Triple(backward, true, jumpCount + 1))
            }
        }

        return -1
    }
}
