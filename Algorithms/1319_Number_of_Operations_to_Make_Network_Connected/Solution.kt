/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-25
 */
class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>) = if (connections.size < n - 1) -1 else 0.until(n)
        .toMutableList()
        .run {
            connections.map { if (it[0] < it[1]) it else intArrayOf(it[1], it[0]) }
                .sortedWith(Comparator { x, y -> if (x[0] == y[0]) x[1] - y[1] else x[0] - y[0] })
                .forEach { (x, y) -> union(x, y) }
            0.until(n).count { this[it] == it } - 1
        }

    private fun MutableList<Int>.union(a: Int, b: Int) {
        val (aRoot, bRoot) = find(a) to find(b)
        if (aRoot != bRoot) {
            this[aRoot] = bRoot
        }
    }

    private fun MutableList<Int>.find(k: Int): Int =
        if (this[k] == k) k else find(this[k]).also { this[k] = it }
}
