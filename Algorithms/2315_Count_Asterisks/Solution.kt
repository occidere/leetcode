class Solution {
    fun countAsterisks(s: String) = s.split('|')
        .toTypedArray()
        .run {
            indices.filter { it % 2 == 0 }
                .map { this[it].count { c -> c == '*' } }
                .sum()
        }
}
