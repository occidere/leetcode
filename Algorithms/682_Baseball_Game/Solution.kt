class Solution {
    fun calPoints(ops: Array<String>) = mutableListOf<Int>().apply {
        ops.forEach { x ->
            when (x) {
                "+" -> this += takeLast(2).sum()
                "D" -> this += last() * 2
                "C" -> removeAt(size - 1)
                else -> this += x.toInt()
            }
        }
    }.sum()
}
