class Solution {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        var remains = additionalRocks
        return capacity.zip(rocks)
            .map { it.first - it.second }
            .sorted()
            .map {
                if (it in 1..remains) {
                    remains -= it
                    0
                } else it
            }.count { it == 0 }
    }
}
