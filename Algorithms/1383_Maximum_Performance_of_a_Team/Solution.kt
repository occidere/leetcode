import java.util.PriorityQueue
import kotlin.math.max

/**
 * Ref: https://me2.do/FfWcg6F6
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-11
 */
class Solution {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val engineers = speed.zip(efficiency).sortedWith(Comparator { x, y -> y.second - x.second })
        val pq = PriorityQueue<Int>(k)
        var (res, sumOfSpeed) = 0L to 0L
        for ((s, e) in engineers) {
            pq.add(s)
            sumOfSpeed += s
            if (k < pq.size) {
                sumOfSpeed -= pq.poll()
            }
            res = max(res, sumOfSpeed * e)
        }
        return (res % 1000000007).toInt()
    }
}
