class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val list: MutableList<String> = mutableListOf()
        dfs(list, "", 0, 0, n)
        return list
    }

    private fun dfs(list: MutableList<String>, p: String, open: Int, close: Int, max: Int) {
        if (p.length == max * 2) {
            list.add(p)
            return
        }

        if (open < max) {
            dfs(list, "$p(", open + 1, close, max)
        }
        if (close < open) {
            dfs(list, "$p)", open, close + 1, max)
        }
    }
}
