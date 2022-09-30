/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-30
 */
class Solution {
    fun removeStars(s: String): String {
        val stk = java.util.Stack<Char>()
        for (c in s) {
            if (c == '*') {
                stk.pop()
            } else {
                stk.push(c)
            }
        }
        return stk.joinToString("")
    }
}
