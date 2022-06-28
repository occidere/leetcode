class Solution {
    fun minDeletions(s: String) = s.groupBy { it }
        .values
        .map { it.size }
        .sortedDescending()
        .let { freq ->
            val uniq = mutableSetOf(freq.first())
            freq.drop(1)
                .map {
                    var cur = it
                    while (cur > 0 && uniq.contains(cur)) {
                        --cur
                    }
                    uniq += cur
                    it - cur
                }.sum()
        }
}
