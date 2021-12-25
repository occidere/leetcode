class Solution {
    fun firstPalindrome(words: Array<String>) = words.firstOrNull() { it.isPalindrome() } ?: ""

    private fun String.isPalindrome(): Boolean {
        val half = this.length.shr(1)
        for (i in 0..half) {
            if (this[i] != this[this.length - i - 1]) {
                return false
            }
        }
        return true
    }
}
