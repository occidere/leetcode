import kotlin.math.max

class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray) = Triple(target[0], target[1], target[2])
        .let { tg ->
            tg == triplets.map { Triple(it[0], it[1], it[2]) }
                .filter { it.first <= tg.first && it.second <= tg.second && it.third <= tg.third }
                .ifEmpty { listOf(Triple(0, 0, 0)) }
                .reduce { acc, t ->
                    Triple(
                        max(acc.first, t.first),
                        max(acc.second, t.second),
                        max(acc.third, t.third)
                    )
                }
        }
}
