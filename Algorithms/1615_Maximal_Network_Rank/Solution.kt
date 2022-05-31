class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>) = roads.map { it.sortedArray() }
        .flatMap {
            listOf(
                it[0] to "${it[0]}_${it[1]}",
                it[1] to "${it[0]}_${it[1]}"
            )
        }.groupBy({ it.first }, { it.second })
        .values
        .map { it.toSet() }
        .run {
            flatMap { c1 ->
                map { c2 -> (c1 + c2).size }
            }
        }.max() ?: 0
}
