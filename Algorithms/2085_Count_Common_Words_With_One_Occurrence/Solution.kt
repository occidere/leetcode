class Solution {
    fun countWords(words1: Array<String>, words2: Array<String>) = words1.groupBy { it }
        .filter { it.value.size == 1 }
        .keys
        .intersect(words2.groupBy { it }.filter { it.value.size == 1 }.keys)
        .size
}
