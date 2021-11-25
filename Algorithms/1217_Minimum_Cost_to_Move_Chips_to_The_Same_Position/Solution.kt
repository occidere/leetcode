class Solution {
    fun minCostToMoveChips(position: IntArray) = position.map { it.rem(2) to (it + 1).rem(2) }
        .reduce { acc, p -> Pair(acc.first + p.first, acc.second + p.second) }
        .run { kotlin.math.min(first, second) }
}
