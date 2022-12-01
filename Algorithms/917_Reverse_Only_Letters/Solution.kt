/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-01
 */
class Solution {
    fun reverseOnlyLetters(s: String): String {
        val cs = s.toCharArray()
        var (i, j) = 0 to s.length - 1
        while (i < j) {
            if (!cs[i].isLetter()) {
                ++i
            } else if (!cs[j].isLetter()) {
                --j
            } else {
                val tmp = cs[i]
                cs[i++] = cs[j]
                cs[j--] = tmp
            }
        }
        return cs.joinToString("")
    }
}
