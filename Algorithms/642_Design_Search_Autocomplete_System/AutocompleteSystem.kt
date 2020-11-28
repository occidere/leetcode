/**
 * @author occidere
 * @Github: https://github.com/occidere
 * @Blog: https://blog.naver.com/occidere
 * @since 2020-11-28
 */
class AutocompleteSystem(sentences: Array<String>, times: IntArray) {
    private val sentenceBuilder = StringBuilder()
    private val histories: MutableMap<String, Int> = times.zip(sentences)
            .map { it.second to it.first }
            .fold(mutableMapOf()) { acc, pair ->
                acc[pair.first] = pair.second
                acc
            }

    fun input(c: Char): List<String> =
            if (c != '#') sentenceBuilder.append(c).toString().getTop3()
            else sentenceBuilder.toString().let {
                histories[it] = histories.getOrDefault(it, 0) + 1
                sentenceBuilder.clear()
                listOf<String>()
            }

    private fun String.getTop3(): List<String> = histories.filterKeys { it.startsWith(this) }
            .toList()
            .sortedWith(Comparator { a, b -> if (a.second == b.second) a.first.compareTo(b.first) else b.second.compareTo(a.second) })
            .map { it.first }
            .take(3)
}