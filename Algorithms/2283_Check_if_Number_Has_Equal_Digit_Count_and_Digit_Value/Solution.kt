class Solution {
    fun digitCount(num: String): Boolean {
        val group = num.map { it - '0' }
            .groupBy { it }
            .mapValues { it.value.size }
        for (i in num.indices) {
            if (group.getOrDefault(i, 0) != num[i] - '0') {
                return false
            }
        }
        return true
    }
}
