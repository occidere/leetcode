/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-09
 */
class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        var acc = 0
        val shifted = s.toMutableList()
        for (i in shifts.indices.reversed()) {
            acc = (shifts[i] + acc) % 26
            shifted[i] = 'a' + ((shifted[i] - 'a' + acc) % 26)
        }
        return shifted.joinToString("")
    }
}
