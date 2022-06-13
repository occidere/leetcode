class Solution {
    fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String = s.map { it.toString() }
        .toTypedArray()
        .apply {
            indices.zip(sources.zip(targets))
                .sortedBy { it.first }
                .filter { (i, p) -> i + p.first.length <= s.length }
                .map { (i, p) ->
                    val range = i until i + p.first.length
                    if (s.substring(range) == p.first) {
                        for (j in range) {
                            this[j] = ""
                        }
                        this[i] = p.second
                    }
                }
        }.joinToString("")
}
