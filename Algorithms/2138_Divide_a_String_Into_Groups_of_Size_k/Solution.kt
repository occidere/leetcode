/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-06
 */
class Solution {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val (chs, res) = s.toMutableList() to mutableListOf<String>()
        while (k <= chs.size) {
            res.add((1..k).map { chs.removeAt(0) }.joinToString(""))
        }
        if (chs.isNotEmpty()) {
            res.add(chs.joinToString("").let { it + (1..k - it.length).joinToString("") { "$fill" } })
        }
        return res.toTypedArray()
    }
}
