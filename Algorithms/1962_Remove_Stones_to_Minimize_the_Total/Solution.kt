/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-28
 */
class Solution {
    fun minStoneSum(piles: IntArray, k: Int) =
        java.util.PriorityQueue<Int>(kotlin.Comparator { x, y -> y - x })
            .apply { addAll(piles.toList()) }
            .also { pq ->
                repeat(k) {
                    pq.add(pq.poll().let { it - it.shr(1) })
                }
            }.sum()
}
