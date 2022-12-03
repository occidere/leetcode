/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-03
 */
class Solution {
    fun maxPower(s: String): Int {
        var (prev, len, maxLen) = Triple('.', 1, 1)
        for (c in s) {
            if (prev != c) {
                maxLen = kotlin.math.max(maxLen, len)
                len = 0
                prev = c
            }
            ++len
        }
        return kotlin.math.max(maxLen, len)
    }
}
