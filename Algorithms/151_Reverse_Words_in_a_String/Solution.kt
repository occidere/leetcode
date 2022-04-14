class Solution {

//    fun reverseWords(s: String) = s.split(" ")
//        .reversed()
//        .map { it.trim() }
//        .filter { it.isNotEmpty() }
//        .joinToString(" ")

    // Follow up failed
    // Ref: https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)
    fun reverseWords(s: String): String {
        val cs = s.toCharArray()

        // 1. Reverse whole string
        cs.reverse()

        // 2. Reverse each word
        cs.reverseWords()

        // 3. Clean up spaces
        return cs.cleanSpaces()
    }

    private fun CharArray.reverseWords() {
        var (i, j) = 0 to 0
        while (i < size) {
            while (i < j || i < size && this[i].toInt() == 32) ++i // skip spaces
            while (j < i || j < size && this[j].toInt() != 32) ++j // skip non spaces
            reverse(i, j - 1) // reverse word
        }
    }

    private fun CharArray.cleanSpaces(): String {
        var (i, j) = 0 to 0
        while (j < size) {
            while (j < size && this[j].toInt() == 32) ++j // skip spaces
            while (j < size && this[j].toInt() != 32) this[i++] = this[j++] // keep no spaces
            while (j < size && this[j].toInt() == 32) ++j // skip spaces
            if (j < size) this[i++] = 32.toChar() // keep only one space
        }
        return 0.until(i).map { this[it] }.joinToString("")
    }

    private fun CharArray.reverse(from: Int, to: Int) {
        var (i, j) = from to to
        while (i < j) {
            val t = this[i]
            this[i++] = this[j]
            this[j--] = t
        }
    }
}
