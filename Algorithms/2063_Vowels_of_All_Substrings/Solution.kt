class Solution {
    fun countVowels(word: String): Long {
        var (numberOfVowels, a, b) = Triple(0L, 1L, word.length.toLong())
        for (c in word) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numberOfVowels += a * b
            }
            ++a
            --b
        }
        return numberOfVowels
    }
}
