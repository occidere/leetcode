class Solution {
    fun validPalindrome(s: String, deleted: Boolean = false): Boolean {
        var (left, right) = -1 to s.length
        while (++left <= --right) {
            if (s[left] != s[right]) {
                return !deleted && (validPalindrome(s.substring(left, right), true) ||
                        validPalindrome(s.substring(left + 1, right + 1), true))
            }
        }
        return true
    }
}
