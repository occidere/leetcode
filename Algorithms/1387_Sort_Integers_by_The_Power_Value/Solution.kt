class Solution {
    fun getKth(lo: Int, hi: Int, k: Int) = (lo..hi).map { (it to it.toPowerVal()) }
            .sortedWith(Comparator { a, b -> if (a.second == b.second) a.first - b.first else a.second - b.second })[k - 1]
            .first

    private fun Int.toPowerVal(): Int {
        var (i, n) = this to 0
        while (i != 1) {
            i = if (i % 2 == 0) i shr 1 else 3 * i + 1
            ++n
        }
        return n
    }
}
