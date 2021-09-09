class Solution {
    fun findWords(words: Array<String>) = arrayOf("qwertyuiop".toSet(), "asdfghjkl".toSet(), "zxcvbnm".toSet()).let { rows ->
        words.filter {
            it.toLowerCase()
                .toSet()
                .run { rows[0].containsAll(this) || rows[1].containsAll(this) || rows[2].containsAll(this) }
        }.toTypedArray()
    }
}
