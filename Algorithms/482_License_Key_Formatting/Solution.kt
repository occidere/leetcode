/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-20
 */
class Solution {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val (cs, tmp) = s.filter { it != '-' }.reversed() to mutableListOf<Char>()
        val res = mutableListOf<String>()
        for (c in cs) {
            tmp.add(c)
            if (tmp.size == k) {
                res.add(tmp.joinToString(""))
                tmp.clear()
            }
        }
        if (tmp.isNotEmpty()) {
            res.add(tmp.joinToString(""))
        }
        return res.joinToString("-") { it.toUpperCase() }
            .reversed()
    }
}
