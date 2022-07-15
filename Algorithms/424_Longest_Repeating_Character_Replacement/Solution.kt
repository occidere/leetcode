import kotlin.math.max

/**
 * Ref: https://me2.do/FaZJtQvL
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-15
 */
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26) { 0 }
        var (maxFreq, maxLen) = 0 to 0
        var i = 0
        for (j in s.indices) {
            maxFreq = max(maxFreq, ++freq[s[j] - 'A'])
            val charsToChange = j - i + 1 - maxFreq
            if (charsToChange > k) {
                --freq[s[i++] - 'A']
            }
            maxLen = max(maxLen, j - i + 1)
        }

        return maxLen
    }
}
