/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-26
 */
class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int = chars.toCharMap()
        .let { charMap -> words.filter { it.isGoodWith(charMap) } }
        .joinToString("")
        .length

    private fun String.isGoodWith(charMap: Map<Char, Int>): Boolean {
        for ((k, v) in toCharMap()) {
            if (charMap.getValue(k) < v) {
                return false
            }
        }
        return true
    }

    private fun String.toCharMap() = groupBy { it }
        .mapValues { it.value.size }
        .withDefault { 0 }
}
