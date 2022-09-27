/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-27
 */
class Solution {
    fun pushDominoes(dominoes: String): String {
        val res = "L${dominoes}R".toMutableList()
        val vs = mutableListOf<Pair<Int, Int>>()
        val tmp = mutableListOf<Int>()
        for (d in res.indices.map { if (res[it] == '.') it else -1 }) {
            if (d == -1) {
                if (tmp.isNotEmpty()) {
                    vs.add(tmp.first() to tmp.last())
                    tmp.clear()
                }
            } else {
                tmp.add(d)
            }
        }
        if (tmp.isNotEmpty()) {
            vs.add(tmp.first() to tmp.last())
        }

        for ((l, r) in vs) {
            val (left, right) = res[l - 1] to res[r + 1]
            if (left == 'R' && right == 'L') {
                val mid = (l + r).shr(1)
                (l..mid).forEach { res[it] = 'R' }
                (mid + 1..r).forEach { res[it] = 'L' }
                res[mid] = if ((r - l + 1) % 2 == 1) '.' else res[mid]
            } else {
                val d = when (left to right) {
                    'L' to 'L' -> 'L'
                    'R' to 'R' -> 'R'
                    else -> '.'
                }
                (l..r).forEach { res[it] = d }
            }
        }
        return res.subList(1, res.size - 1).joinToString("")
    }
}
