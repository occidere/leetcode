/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-21
 */
class Solution {
    private val wordScoreMap = mutableMapOf<String, Int>().withDefault { 0 }
    private val scoreByLetter = IntArray(26) { 0 }

    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        letters.forEach { ++scoreByLetter[it - 'a'] }
        score.indices
            .associateBy({ 'a' + it }) { score[it] }
            .let { letterScoreMap ->
                words.forEach { w -> wordScoreMap[w] = w.sumBy { letterScoreMap[it]!! } }
            }
        return words.dfs(-1, 0, BooleanArray(words.size) { false })
    }

    private fun Array<String>.dfs(idx: Int, acc: Int, visit: BooleanArray): Int {
        var maxScore = acc

        for (i in idx + 1 until size) {
            if (!visit[i] && this[i].isAvailable()) {
                visit[i] = true
                this[i].select()

                maxScore = kotlin.math.max(maxScore, dfs(i, acc + wordScoreMap.getValue(this[i]), visit))

                visit[i] = false
                this[i].unselect()
            }
        }

        return maxScore
    }

    private fun String.isAvailable() = groupBy { it }
        .map { it.key to it.value.size }
        .all { (ch, cnt) -> scoreByLetter[ch - 'a'] >= cnt }

    private fun String.select() {
        forEach { --scoreByLetter[it - 'a'] }
    }

    private fun String.unselect() {
        forEach { ++scoreByLetter[it - 'a'] }
    }
}
