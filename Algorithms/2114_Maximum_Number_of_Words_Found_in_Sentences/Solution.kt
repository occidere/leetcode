class Solution {
    fun mostWordsFound(sentences: Array<String>) = sentences.map { it.split(" ") }
        .map { it.size }
        .max()!!
}
