class Solution {
    fun numOfStrings(patterns: Array<String>, word: String) = patterns.filter { word.contains(it) }.count()
}
