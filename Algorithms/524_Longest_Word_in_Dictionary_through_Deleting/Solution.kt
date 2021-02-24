class Solution {
    fun findLongestWord(s: String, d: List<String>): String =
        d.sortedWith(Comparator { x, y -> if (x.length == y.length) x.compareTo(y) else y.length - x.length })
            .find {
                var (i, j) = 0 to 0
                while (i < s.length && j < it.length) {
                    if (s[i++] == it[j]) ++j
                }
                j == it.length
            }
            .orEmpty()
}