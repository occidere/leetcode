/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-22
 */
class Solution {
    fun makeFancyString(s: String): String {
        val toStr = { list: List<Char> -> list.joinToString("").let { it.substring(0, kotlin.math.min(it.length, 2)) } }
        val (fancy, tmp) = mutableListOf<String>() to mutableListOf(s[0])
        for (c in s.drop(1)) {
            if (tmp.last() != c) {
                fancy.add(toStr(tmp))
                tmp.clear()
            }
            tmp.add(c)
        }
        fancy.add(toStr(tmp))
        return fancy.joinToString("")
    }
}
