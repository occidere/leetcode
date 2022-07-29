/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-29
 */
class Solution {
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        val visit = mutableSetOf<String>()
        val q = mutableListOf(start to 0)
        while (q.isNotEmpty()) {
            val (cur, cnt) = q.removeAt(0)
            if (cur == end) {
                return cnt
            }
            for (next in bank.getNextMutationsFrom(cur)) {
                if (!visit.contains(next)) {
                    visit.add(next)
                    q.add(next to cnt + 1)
                }
            }
        }

        return -1
    }

    private fun Array<String>.getNextMutationsFrom(cur: String) = filter { x -> 0.until(8).count { cur[it] != x[it] } == 1 }
}
