/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-18
 */
class Solution {
    fun isUgly(n: Int): Boolean {
        if (n < 1) {
            return false
        } else {
            var k = n
            while (6 < k) {
                if (k % 2 == 0) {
                    k = k.shr(1)
                } else if (k % 3 == 0) {
                    k /= 3
                } else if (k % 5 == 0) {
                    k /= 5
                } else {
                    return false
                }
            }
            return true
        }
    }
}
