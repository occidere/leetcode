class Solution {
    fun minDeletions(s: String) = s.groupBy { it }
        .values
        .map { it.size }
        .sortedDescending()
        .let { freq ->
            val uniq = mutableSetOf(freq.first())
            freq.drop(1)
                .map {
                    var (cost, cur) = 0 to it
                    while (cur > 0 && uniq.contains(cur)) {
                        --cur
                        ++cost
                    }
                    uniq += cur
                    cost
                }.sum()
        }
}
