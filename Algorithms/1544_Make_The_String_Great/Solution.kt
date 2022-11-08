/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-08
 */
class Solution {
    fun makeGood(s: String): String {
        val q = s.toMutableList()
        val tmp = mutableListOf<Char>()
        while (1 < q.size) {
            val (x, y) = q.removeAt(0) to q.removeAt(0)
            if ((x.toLowerCase() == y.toLowerCase() && x != y)) {
                q.addAll(0, tmp)
                tmp.clear()
                continue
            } else {
                tmp.add(x)
                q.add(0, y)
            }
        }
        q.addAll(0, tmp)
        return q.joinToString("")
    }
}
