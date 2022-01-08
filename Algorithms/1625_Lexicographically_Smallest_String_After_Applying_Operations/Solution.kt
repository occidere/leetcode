class Solution {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val visit = mutableSetOf(s)
        val q = mutableListOf(s)
        while (q.isNotEmpty()) {
            q.removeAt(0).apply {
                visit += listOf(rotate(b), addOnOddDigits(a))
                    .filter { !visit.contains(it) }
                    .also { q += it }
            }
        }

        return visit.min()!!
    }

    private fun String.rotate(b: Int) = substring(b, length) + substring(0, b)

    private fun String.addOnOddDigits(a: Int) = indices
        .map { if (it % 2 == 1) this[it] + a else this[it] }
        .map { it - '0' }
        .map { if (it > 9) it - 10 else it }
        .joinToString("")
}
