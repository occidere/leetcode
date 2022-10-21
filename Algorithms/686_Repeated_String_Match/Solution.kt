/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-21
 */
class Solution {
    fun repeatedStringMatch(a: String, b: String): Int {
        val tmp = mutableListOf<String>()
        var tmpLen = 0
        while (tmpLen < b.length) {
            tmp.add(a)
            tmpLen += a.length
        }
        val repeated = tmp.joinToString("")
        return if (repeated.contains(b)) {
            repeated.length / a.length
        } else if ("$a$repeated".contains(b)) {
            repeated.length / a.length + 1
        } else {
            -1
        }
    }
}
