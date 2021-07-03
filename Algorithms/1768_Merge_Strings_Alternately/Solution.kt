class Solution {
    fun mergeAlternately(word1: String, word2: String): String = word1.zip(word2).joinToString("") { "${it.first}${it.second}" } +
            if (word1.length < word2.length) word2.substring(word1.length)
            else word1.substring(word2.length)
}
