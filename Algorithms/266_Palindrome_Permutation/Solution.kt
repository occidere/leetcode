class Solution {
    fun canPermutePalindrome(s: String): Boolean = mutableSetOf<Char>().apply {
        for (c in s) {
            if (c in this) this.remove(c) else this += c
        }
    }.size < 2
}