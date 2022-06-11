class Solution {
    private val root = Node('.')

    fun longestWord(words: Array<String>) = words.distinct()
        .sortedBy { it.length }
        .map { root.add(it) }
        .sortedWith(Comparator { x, y -> if (x.length == y.length) x.compareTo(y) else y.length - x.length })
        .first()

    private fun Node.add(s: String): String {
        var head: Node = this
        for (i in s.indices) {
            val (c, next) = s[i] to head.children[s[i] - 'a']
            if (next != null) {
                head = next
            } else if (i == s.length - 1) {
                head.children[c - 'a'] = Node(c)
                return s
            } else {
                break
            }
        }
        return ""
    }

    private data class Node(val c: Char) {
        val children = Array<Node?>(26) { null }
    }
}
