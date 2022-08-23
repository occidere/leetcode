/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-23
 */
class Solution {
    fun greatestLetter(s: String): String {
        val (uppers, lowers) = IntArray(26) { 0 } to IntArray(26) { 0 }
        for (c in s) {
            if (c in 'a'..'z') {
                ++lowers[c - 'a']
            } else {
                ++uppers[c - 'A']
            }
        }
        
        for (i in 25 downTo 0) {
            if (uppers[i] > 0 && lowers[i] > 0) {
                return "${'A' + i}"
            }
        }
        return ""
    }
}
