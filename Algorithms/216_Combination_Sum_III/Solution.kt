class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        fun dfs(num: Int, selected: List<Int>, acc: Int) {
            if (acc == n && selected.size == k) {
                res += selected.toList()
                return
            }
            for (i in num..9) {
                dfs(i + 1, selected + listOf(i), acc + i)
            }
        }
        dfs(1, listOf(), 0)
        return res
    }
}
