/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-19
 */
class Solution {
    fun reverseStr(s: String, k: Int): String {
        val (cs, tmp) = mutableListOf<String>() to mutableListOf<Char>()
        for (i in s.indices) {
            tmp.add(s[i])
            if (tmp.size == k) {
                cs.add(tmp.joinToString(""))
                tmp.clear()
            }
        }
        if (tmp.isNotEmpty()) {
            cs.add(tmp.joinToString(""))
        }
        return cs.indices
            .joinToString("") { if (it % 2 == 0) cs[it].reversed() else cs[it] }
    }
}
