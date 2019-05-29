class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return if (p.isEmpty()) {
            s.isEmpty()
        } else {
            val firstMatch = !s.isEmpty() && (s[0] == p[0] || p[0] == '.')
            if (p.length > 1 && p[1] == '*') {
                isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
            } else {
                firstMatch && isMatch(s.substring(1), p.substring(1))
            }
        }
    }
}
