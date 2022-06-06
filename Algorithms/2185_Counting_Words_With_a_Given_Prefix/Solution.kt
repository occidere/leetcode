class Solution {
    fun prefixCount(words: Array<String>, pref: String) = words.count { it.startsWith(pref) }
}
