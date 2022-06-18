class Solution {
    private val memo = mutableMapOf<Long, Int>().withDefault { 0x3f3f3f3f }

    fun integerReplacement(n: Int): Int {
        solve(n.toLong())
        return memo[1]!!
    }

    private fun solve(n: Long, acc: Int = 0) {
        if (n == 1L) {
            memo[n] = kotlin.math.min(memo.getValue(n), acc)
            memo[n]!!
        } else if (n % 2 == 0L) {
            val next = n.shr(1)
            if (acc + 1 < memo.getValue(next)) {
                memo[next] = acc + 1
                solve(next, acc + 1)
            }
        } else {
            val (next1, next2) = n - 1 to n + 1
            val (memo1, memo2) = memo.getValue(next1) to memo.getValue(next2)
            if (acc + 1 < memo1) {
                memo[next1] = acc + 1
                solve(next1, acc + 1)
            }
            if (acc + 1 < memo2) {
                memo[next2] = acc + 1
                solve(next2, acc + 1)
            }
        }
    }
}
