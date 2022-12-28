/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-26
 */
class Solution {
    fun similarPairs(words: Array<String>) =
        words.map { it.asSequence().toSortedSet().joinToString("") }
            .let { ws -> ws.indices.sumBy { i -> (i + 1 until ws.size).count { j -> ws[i] == ws[j] } } }
}
