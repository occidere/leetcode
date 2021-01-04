class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean =
        word1.joinToString("").equals(word2.joinToString(""))
}