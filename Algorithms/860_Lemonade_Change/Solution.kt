/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-03
 */
class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        val changes = mutableMapOf(5 to 0, 10 to 0, 20 to 0)
        for (b in bills) {
            changes[b] = changes[b]!! + 1
            var change = b - 5
            for (c in changes.keys.reversed()) {
                while (c <= change && 0 < change && 0 < changes[c]!!) {
                    change -= c
                    changes[c] = changes[c]!! - 1
                }
            }
            if (change != 0) {
                return false
            }
        }
        return true
    }
}
