class Solution {
    fun customSortString(order: String, s: String) = order.withIndex()
        .associate { it.value to it.index }
        .withDefault { Int.MAX_VALUE }
        .run {
            s.asSequence()
                .sortedWith(Comparator { x, y -> getValue(x) - getValue(y) })
                .joinToString("")
        }
}
