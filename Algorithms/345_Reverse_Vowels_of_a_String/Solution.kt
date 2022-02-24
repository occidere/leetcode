class Solution {
    fun reverseVowels(s: String): String {
        val isVowel =
            { ch: Char -> ch.toLowerCase().let { c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' } }
        val changePos = s.indices
            .filter { isVowel(s[it]) }
            .run { zip(reversed()) }
            .toMap()
        return s.indices
            .map { if (isVowel(s[it])) s[changePos[it]!!] else s[it] }
            .joinToString("")
    }
}
