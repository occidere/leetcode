class Solution {
    private val good = setOf(0, 1, 8)
    private val better = setOf(2, 5, 6, 9)
    private val rotatable = good + better

    fun rotatedDigits(n: Int) = (0..n).count { it.isRotatable() && it.hasAnyBetterElement() }

    private fun Int.isRotatable() = toString().all { rotatable.contains(it - '0') }

    private fun Int.hasAnyBetterElement() = toString().any { better.contains(it - '0') }
}
