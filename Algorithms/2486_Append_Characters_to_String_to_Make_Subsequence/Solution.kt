/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-17
 */
class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var (i, j, matched) = Triple(0, 0, 0)
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                ++matched
                ++j
            }
            ++i
        }
        return t.length - matched
    }
}
