class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        return if (words.isEmpty()) {
            emptyList()
        } else {
            val wordCount = mutableMapOf<String, Int>()
            for (word in words) {
                wordCount.merge(word, 1, Int::plus)
            }

            val sLen = s.length
            val aLen = words.size
            val wLen = words[0].length
            val indices = mutableListOf<Int>()

            for (i in 0 until sLen - wLen * aLen + 1) {
                val found = mutableMapOf<String, Int>()
                for (j in 0 until aLen) {
                    val word = s.substring(i + j * wLen, i + (j + 1) * wLen)
                    if (wordCount.containsKey(word)) {
                        found.merge(word, 1, Int::plus)
                        if (found[word]!! > wordCount.getOrDefault(word, 0)) {
                            break
                        }
                    } else {
                        break
                    }

                    if (j == aLen - 1) {
                        indices.add(i)
                    }
                }
            }
            indices
        }
    }
}
