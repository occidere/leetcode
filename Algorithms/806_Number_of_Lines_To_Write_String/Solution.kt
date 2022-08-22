/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-22
 */
class Solution {
    fun numberOfLines(widths: IntArray, s: String): IntArray {
        val res = intArrayOf(1, 0)
        for (c in s) {
            if (res[1] + widths[c - 'a'] > 100) {
                ++res[0]
                res[1] = widths[c - 'a']
            } else {
                res[1] += widths[c - 'a']
            }
        }
        return res
    }
}
