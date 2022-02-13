class Solution {
    fun findRepeatedDnaSequences(s: String) = (10..(s.length)).asSequence()
        .map { s.substring(it - 10, it) }
        .groupBy { it }
        .map { it.key to it.value.size }
        .filter { it.second > 1 }
        .map { it.first }
        .toList()
}
