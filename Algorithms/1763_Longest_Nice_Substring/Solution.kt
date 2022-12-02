/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-02
 */
class Solution {
    fun longestNiceSubstring(s: String): String {
        var longestNice = mutableListOf<Pair<String, Int>>()
        for (len in 1..s.length) {
            for (i in len..s.length) {
                val sub = s.substring(i - len, i)
                if (sub.isNice()) {
                    longestNice.add(sub to i)
                }
            }
        }
        return longestNice.sortedWith(Comparator { xs, ys -> if (xs.first.length == ys.first.length) xs.second - ys.second else ys.first.length - xs.first.length })
            .map { it.first }
            .firstOrNull() ?: ""
    }

    private fun String.isNice() = groupBy { it }.let { grp ->
        all { grp.contains(it.toLowerCase()) && grp.contains(it.toUpperCase()) }
    }
}
