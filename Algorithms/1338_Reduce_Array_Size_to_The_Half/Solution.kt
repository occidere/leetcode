class Solution {
    fun minSetSize(arr: IntArray): Int {
        var acc = 0
        return 1 + arr.fold(mutableMapOf<Int, Int>(), { m, n -> m.merge(n, 1, Integer::sum); m })
            .values
            .sortedWith(Comparator { a, b -> b.compareTo(a) })
            .map { acc += it; acc }
            .takeWhile { it < arr.size shr 1 }
            .count()
    }
}