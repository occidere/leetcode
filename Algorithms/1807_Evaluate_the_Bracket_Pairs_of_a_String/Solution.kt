class Solution {
    fun evaluate(s: String, knowledge: List<List<String>>) = knowledge.associate { it[0] to it[1] }.let { kv ->
        s.split(")").joinToString("") {
            if (!it.contains("(")) it else {
                it.split("(").run {
                    first() + kv.getOrDefault(last(), "?")
                }
            }
        }
    }
}
