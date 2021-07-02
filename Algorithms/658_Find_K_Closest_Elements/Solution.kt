mport kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> = arr.map { Pair(abs(it - x), it) }
            .sortedWith(Comparator { x, y -> if (x.first == y.first) x.second - y.second else x.first - y.first })
            .map { it.second }
            .take(k)
            .sorted()
}
