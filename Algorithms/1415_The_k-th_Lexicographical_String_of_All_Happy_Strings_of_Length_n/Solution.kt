/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-24
 */
class Solution {
    private var cnt = 0

    fun getHappyString(n: Int, k: Int, s: String = ""): String = if (s.length == n) {
        if (++cnt == k) s else ""
    } else {
        var res = ""
        for (c in listOf('a', 'b', 'c')) {
            if (c != (s.getOrNull(s.length - 1) ?: ' ')) {
                val ret = getHappyString(n, k, s + c)
                if (ret.isNotEmpty()) {
                    res = ret
                }
            }
        }
        res
    }
}
