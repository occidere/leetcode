class Solution {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val disjointSet = (IntArray(s.length) { -1 }).apply {
            var connected = 0
            for (p in pairs) {
                if (connected >= s.length - 1) {
                    break
                } else if (this.union(p.first(), p.last())) {
                    ++connected
                }
            }
        }
        val rootSet = (IntArray(s.length) { -1 }).apply {
            for (i in disjointSet.indices) {
                var node = i
                while (disjointSet[node] != -1) {
                    node = disjointSet[node]
                }
                this[i] = node
            }
        }
        return rootSet.zip(rootSet.indices)
            .groupBy({ p -> p.first }, { p -> p.second })
            .values
            .flatMap { group -> group.zip(group.map { s[it] }.sorted()) }
            .sortedBy { it.first }
            .map { it.second }
            .joinToString("")
    }

    private fun IntArray.findRoot(node: Int): Int =
        if (this[node] == -1) node else {
            this[node] = findRoot(this[node])
            this[node]
        }

    private fun IntArray.union(node1: Int, node2: Int) =
        (findRoot(node1) to findRoot(node2)).let {
            if (it.first != it.second) {
                this[it.second] = it.first
                true
            } else false
        }
}
