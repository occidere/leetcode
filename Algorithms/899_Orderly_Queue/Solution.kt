/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-06
 */
class Solution {
    fun orderlyQueue(s: String, k: Int): String {
        val cs = s.toMutableList()
        return if (k != 1) {
            cs.sorted().joinToString("")
        } else {
            var ans = s
            repeat(s.length) {
                ans = cs.joinToString("").let { if (it < ans) it else ans }
                cs.add(cs.removeAt(0))
            }
            ans
        }
    }
}
