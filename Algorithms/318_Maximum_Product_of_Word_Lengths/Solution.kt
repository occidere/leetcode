class Solution {
    fun maxProduct(words: Array<String>) = words.map { w ->
        w.map { it - 'a' }
            .map { 1 shl it }
            .reduce { x, y -> x or y }
    }.toIntArray().run {
        indices.flatMap { i ->
            indices.filter { j -> i != j }
                .filter { j -> this[i] and this[j] == 0 }
                .map { j -> words[i].length * words[j].length }
                .ifEmpty { listOf(0) }
        }
    }.max()!!
}
