class Solution {
    fun areOccurrencesEqual(s: String) = s.groupBy { it }.map { it.value.size }.toSet().size == 1
}
