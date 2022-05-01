class Solution {
    fun findWinners(matches: Array<IntArray>) = matches.run {
        map { it.last() }
            .let { losers ->
                listOf(
                    flatMap { it.toList() }.toSet().subtract(losers.toSet()).toList().sorted(),
                    losers.groupBy { it }.filter { it.value.size == 1 }.keys.toList().sorted()
                )
            }
    }
}
