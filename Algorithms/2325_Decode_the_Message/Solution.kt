class Solution {
    fun decodeMessage(key: String, message: String) = key.filter { it != ' ' }
        .toList()
        .distinct()
        .let { it.zip(it.indices.map { i -> (i + 97).toChar() }) }
        .toMap()
        .run {
            message.map { getOrDefault(it, it) }
                .joinToString("")
        }
}
