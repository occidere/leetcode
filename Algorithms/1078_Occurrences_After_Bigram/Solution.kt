/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-23
 */
class Solution {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val texts = text.split(" ")
        val res = mutableListOf<String>()
        for (i in 2 until texts.size) {
            if (texts[i - 2] == first && texts[i - 1] == second) {
                res.add(texts[i])
            }
        }
        return res.toTypedArray()
    }
}
