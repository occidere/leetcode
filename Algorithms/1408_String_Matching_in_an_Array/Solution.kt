/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-21
 */
class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val res = mutableListOf<String>()
        words.sortBy { it.length }
        for (i in words.indices) {
            val ch = words[i]
            for (j in i + 1 until words.size) {
                if (words[j].contains(ch)) {
                    res.add(ch)
                    break
                }
            }
        }
        return res
    }
}
