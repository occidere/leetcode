/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-30
 */
class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val letters = licensePlate.asSequence()
            .filter { it.isLetter() }
            .map { it.toLowerCase() }
            .toFreqMap()
        return words.asSequence()
            .withIndex()
            .map { (i, s) -> Triple(i, s.length, s.asSequence().toFreqMap()) }
            .filter { (_, _, ws) -> letters.all { (k, v) -> v <= ws.getOrDefault(k, 0) } }
            .sortedWith(Comparator { (i, xLen, _), (j, yLen, _) -> if (xLen == yLen) i - j else xLen - yLen })
            .map { words[it.first] }
            .first()
    }

    private fun Sequence<Char>.toFreqMap() =
        groupBy { it }.mapValues { it.value.size }
}
