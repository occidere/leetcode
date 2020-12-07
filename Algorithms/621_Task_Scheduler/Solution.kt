import kotlin.math.max

class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int =
        tasks.fold(mutableMapOf<Char, Int>(), { acc, c -> acc.merge(c, 1, Integer::sum); acc })
            .values
            .sortedWith(Comparator { a, b -> b.compareTo(a) })
            .run { this.filter { it == this.first()  } }
            .let { max(it.size + (it.first() - 1) * (n + 1), tasks.size) }
}