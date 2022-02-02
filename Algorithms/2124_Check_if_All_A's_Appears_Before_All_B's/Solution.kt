class Solution {
    fun checkString(s: String) = s.split("").sorted().joinToString("") == s
}
