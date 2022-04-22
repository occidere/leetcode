class MapSum {

    private val root = Trie('.')

    fun insert(key: String, `val`: Int) {
        var head = root
        for (i in key.indices) {
            val c = key[i]
            if (!head.hasChild(c)) {
                head.addChild(Trie(c))
            }
            head = head.getChild(c)
            if (i == key.length - 1) {
                head.value = `val`
            }
        }
    }

    fun sum(prefix: String): Int {
        var lastNode = root
        for (c in prefix) {
            if (lastNode.hasChild(c)) {
                lastNode = lastNode.getChild(c)
            } else {
                lastNode = Trie('.', 0)
                break
            }
        }
        return sumAllChildren(lastNode)
    }

    private fun sumAllChildren(node: Trie): Int = node.value + node.children.values.map { sumAllChildren(it) }.sum()

    class Trie(private val c: Char, var value: Int = 0) {
        val children = mutableMapOf<Char, Trie>()

        fun hasChild(c: Char) = children.contains(c)

        fun getChild(c: Char) = children[c]!!

        fun addChild(trie: Trie) {
            children[trie.c] = trie
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */
