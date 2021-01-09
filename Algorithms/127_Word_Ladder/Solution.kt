import java.util.*

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val visit = mutableSetOf(beginWord)
        val q = LinkedList<Pair<String, Int>>().also { it.add(Pair(beginWord, 1)) }
        val board: Map<String, List<String>> = (wordList + beginWord)
            .flatMap { w -> beginWord.indices.map { w.createMaskedWord(it) to w } }
            .groupBy(Pair<String, String>::first, Pair<String, String>::second)
            .withDefault { emptyList() }

        while (q.isNotEmpty()) {
            val (curWord, curCost) = q.poll()
            for (i in beginWord.indices) {
                val nextMaskedWord = curWord.createMaskedWord(i)
                for (nextWord in board.getValue(nextMaskedWord)) {
                    if (nextWord == endWord) {
                        return curCost + 1
                    }

                    if (!visit.contains(nextWord)) {
                        visit += nextWord
                        q.offer(Pair(nextWord, curCost + 1))
                    }
                }
            }
        }

        return 0
    }

    private fun String.createMaskedWord(i: Int): String =
        "${this.slice(0 until i)}_${this.slice(i + 1 until this.length)}"
}