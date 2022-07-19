/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-19
 */
class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        for (i in s.length.shr(1) downTo 1) {
            if (s.substring(0, i).isSubstringOf(s)) {
                return true
            }
        }
        return false
    }

    private fun String.isSubstringOf(s: String): Boolean {
        return if (s.length % length != 0) {
            false
        } else {
            for (i in s.indices step length) {
                if (this != s.substring(i, i + length)) {
                    return false
                }
            }
            true
        }
    }
}
