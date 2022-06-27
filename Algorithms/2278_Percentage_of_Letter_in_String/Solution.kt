class Solution {
    fun percentageLetter(s: String, letter: Char) = 100 * s.groupBy { it }
        .mapValues { it.value.size }
        .getOrDefault(letter, 0) / s.length
}
