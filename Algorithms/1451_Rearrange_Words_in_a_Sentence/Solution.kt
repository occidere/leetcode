class Solution {
    fun arrangeWords(text: String) = text.split(" ")
        .let { it.zip(it.indices) }
        .sortedWith(Comparator { x, y -> if (x.first.length == y.first.length) x.second - y.second else x.first.length - y.first.length })
        .map { it.first }
        .let { it.zip(it.indices) }
        .joinToString(" ") { if (it.second == 0) it.first.capitalize() else it.first.toLowerCase() }
}
