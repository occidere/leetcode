/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-13
 */
class Solution {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val (g1, g2) = word1.groupBy { it } to word2.groupBy { it }
        return g1.keys.union(g2.keys)
            .all { kotlin.math.abs(g1.getOrDefault(it, emptyList()).size - g2.getOrDefault(it, emptyList()).size) <= 3 }
    }
}
