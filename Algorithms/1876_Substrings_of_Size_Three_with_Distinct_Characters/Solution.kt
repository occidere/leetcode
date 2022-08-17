/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-17
 */
class Solution {
    fun countGoodSubstrings(s: String): Int {
        var cnt = 0
        for (i in 0 until s.length - 2) {
            if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i + 2] != s[i]) {
                ++cnt
            }
        }
        return cnt
    }
}
