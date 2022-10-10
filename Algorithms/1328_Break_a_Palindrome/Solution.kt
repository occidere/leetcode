/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-10
 */
class Solution {
    fun breakPalindrome(palindrome: String): String {
        val cs = palindrome.toMutableList()
        for (c in 'a'..'z') {
            for (i in cs.indices) {
                if (cs[i] != c) {
                    val tmp = cs[i]
                    cs[i] = c
                    if (!cs.isPalindrome()) {
                        return cs.joinToString("")
                            .let { listOf(it, it.reversed()).min()!! }
                    }
                    cs[i] = tmp
                }
            }
        }
        return ""
    }

    private fun List<Char>.isPalindrome(): Boolean {
        for (i in 0..size.shr(1)) {
            if (this[i] != this[size - i - 1]) {
                return false
            }
        }
        return true
    }
}
