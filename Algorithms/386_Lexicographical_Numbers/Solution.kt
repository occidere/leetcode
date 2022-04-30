class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val lexicalSortedList = mutableListOf<Int>()
        fun dfs(strNum: String = "") {
            for (i in (if (strNum.isEmpty()) 1 else 0)..9) {
                val nextNum = strNum + i
                if (nextNum.toInt() <= n) {
                    lexicalSortedList += nextNum.toInt()
                    dfs(nextNum)
                } else break
            }
        }
        dfs()
        return lexicalSortedList
    }
}
