class Solution {
    fun truncateSentence(s: String, k: Int): String = s.split(" ")
        .take(k)
        .joinToString(" ")
}
