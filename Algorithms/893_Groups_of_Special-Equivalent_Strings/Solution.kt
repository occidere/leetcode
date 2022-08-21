/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-21
 */
class Solution {
    fun numSpecialEquivGroups(words: Array<String>) = words.map { it.sortedByPos() }.groupBy { it }.size

    private fun String.sortedByPos() = indices.map { (it % 2) to this[it] }
        .groupBy({ it.first }) { it.second }
        .withDefault { emptyList() }
        .let { it.getValue(0).sorted() to it.getValue(1).sorted() }
        .let { (evens, odds) ->
            evens.zip(odds)
                .flatMap { listOf(it.first, it.second) }
                .joinToString("") +
                    (if (odds.size < evens.size) evens.last() else "")
        }
}
