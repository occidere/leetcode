class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val n = adjacentPairs.size + 1
        val graph = adjacentPairs.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
            .groupBy({ it.first }, { it.second })
        var cur = graph.filter { it.value.size == 1 }
            .map { it.key }
            .first()
        val visit = mutableSetOf(cur)

        return mutableListOf(cur).apply {
            while (size < n) {
                cur = graph[cur]!!.filterNot { visit.contains(it) }
                    .first()
                    .also {
                        visit += it
                        this += it
                    }
            }
        }.toIntArray()
    }
}
