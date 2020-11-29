class Solution {
    fun countArrangement(n: Int): Int = n.dfs(0, 1)

    private fun Int.dfs(selected: Int, idx: Int, visit: Array<Boolean> = Array(this + 1) { false }): Int =
            if (selected == this) 1
            else (1..this).map {
                var acc = 0
                if (!visit[it] && (it % idx == 0 || idx % it == 0)) {
                    visit[it] = true
                    acc += dfs(selected + 1, idx + 1, visit)
                    visit[it] = false
                }
                acc
            }.sum()
}