/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-10
 */
class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val ans = mutableListOf<Char>()
        val pq = java.util.PriorityQueue<Pair<Char, Int>>(Comparator { xs, ys -> ys.second - xs.second })
            .apply { addAll(listOf('a' to a, 'b' to b, 'c' to c).filter { it.second != 0 }) }
        val tmp = java.util.PriorityQueue<Pair<Char, Int>>(Comparator { xs, ys -> ys.second - xs.second })
        while (pq.isNotEmpty()) {
            var (ch, n) = pq.poll().also { ans.add(it.first) }
            if (0 < --n) {
                tmp.add(ch to n)
            }
            if (tmp.isNotEmpty()) {
                val (last2, last1) = Pair(if (2 <= ans.size) ans[ans.size - 2] else '.', ans.last())
                if (last2 != last1 || last1 != tmp.peek().first) {
                    pq.addAll(tmp)
                    tmp.clear()
                }
            }
        }
        return ans.joinToString("")
    }
}
