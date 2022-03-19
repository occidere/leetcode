class Solution {
    fun findRelativeRanks(score: IntArray) = score.sortedDescending()
        .zip(score.indices)
        .associate {
            it.first to when (it.second) {
                0 -> "Gold Medal"
                1 -> "Silver Medal"
                2 -> "Bronze Medal"
                else -> "${it.second + 1}"
            }
        }.run { score.map { get(it)!! } }
        .toTypedArray()
}
