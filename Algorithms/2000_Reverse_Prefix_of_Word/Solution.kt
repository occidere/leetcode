import kotlin.math.max

class Solution {
    fun reversePrefix(word: String, ch: Char) = max(word.indexOfFirst { it == ch }, 0)
        .let { "${word.substring(0..it).reversed()}${word.substring(it + 1 until word.length)}" }
}
