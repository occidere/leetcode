class Solution {
    fun cellsInRange(s: String) = (s[0]..s[3]).flatMap { r -> (s[1]..s[4]).map { c -> "$r${c - '0'}" } }
}
