import kotlin.math.min

class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        val toFreq = { arr: IntArray ->
            arr.groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
                .withDefault { -0x3f3f3f3f }
        }
        val (topFreq, botFreq) = toFreq(tops) to toFreq(bottoms)
        return (topFreq.keys + botFreq.keys)
            .filter { topFreq.getValue(it) + botFreq.getValue(it) >= tops.size }
            .map { it to min(tops.size - topFreq[it]!!, tops.size - botFreq[it]!!) }
            .sortedBy { it.second }
            .map { candidate ->
                candidate.second to tops.zip(bottoms)
                    .map { it.first == candidate.first || it.second == candidate.first }
                    .reduce { acc, b -> acc.and(b) }
            }.firstOrNull { it.second }?.first ?: -1
    }
}
