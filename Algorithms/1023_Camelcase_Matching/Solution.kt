class Solution {
    fun camelMatch(queries: Array<String>, pattern: String) = queries.map { it.isMatched(pattern) }

    private fun String.isMatched(pattern: String): Boolean {
        var (i, j) = 0 to 0
        while (i < length && j < pattern.length) {
            if (this[i] == pattern[j]) {
                ++i
                ++j
            } else if (this[i].isUpperCase()) {
                return false
            } else {
                ++i
            }
        }
        return j == pattern.length && substring(i).none { it.isUpperCase() }
    }
}
