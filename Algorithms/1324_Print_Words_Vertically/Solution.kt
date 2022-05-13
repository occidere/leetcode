class Solution {
    fun printVertically(s: String) = s.split(" ").toTypedArray().run {
        0.until(map { it.length }.max()!!)
            .map { i ->
                indices.map { j -> if (i < this[j].length) this[j][i] else ' ' }
                    .joinToString("")
                    .trimEnd()
            }
    }
}
