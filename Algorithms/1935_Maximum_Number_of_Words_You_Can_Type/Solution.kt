class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String) = brokenLetters.toSet().run {
        text.split(" ")
            .filter { it.none { c -> contains(c) } }
            .size
    }
}
