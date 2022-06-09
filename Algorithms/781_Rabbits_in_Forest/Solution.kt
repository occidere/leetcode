class Solution {
    fun numRabbits(answers: IntArray) = answers.groupBy { it }
        .mapValues { (k, v) -> v.size / (k + 1) + if (v.size % (k + 1) != 0) 1 else 0 }
        .map { (it.key + 1) * it.value }
        .sum()
}
