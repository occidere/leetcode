/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-29
 */
class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        val res = mutableListOf<Char>()
        var j = 0
        for (i in s.indices) {
            if (j < spaces.size && i == spaces[j]) {
                ++j
                res.add(' ')
            }
            res.add(s[i])
        }
        return res.joinToString("")
    }
}
