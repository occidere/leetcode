class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray = deck.sortedDescending().let { sortedDeck ->
        ArrayDeque<Int>().apply { addFirst(sortedDeck.first()) }
                .apply {
                    sortedDeck.drop(1)
                            .forEach {
                                addFirst(removeLast())
                                addFirst(it)
                            }
                }.toIntArray()
    }
}
