class Solution {
    fun removeOuterParentheses(s: String): String {
        val idx = arrayListOf<Int>().apply { add(-1) }
        var (open, close) = Pair(0, 0)

        for (i in s.indices) {
            if (s[i] == '(') ++open else ++close
            if (open == close) {
                idx += i
                open = 0
                close = 0
            }
        }

        return (1 until idx.size).joinToString("") { s.substring(idx[it - 1] + 2, idx[it]) }
    }
}
