/**
 * Ref: https://leetcode.com/problems/matchsticks-to-square/discuss/95729/Java-DFS-Solution-with-Explanation
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-12
 */
class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        matchsticks.sortDescending()
        val total = matchsticks.sum()
        return total % 4 == 0 && matchsticks.dfs(0, intArrayOf(0, 0, 0, 0), total.shr(2))
    }

    private fun IntArray.dfs(idx: Int, acc: IntArray, target: Int): Boolean {
        if (idx == size) {
            return acc.all { it == target }
        }

        for (i in 0..3) {
            if (acc[i] + this[idx] <= target) {
                acc[i] += this[idx]
                if (dfs(idx + 1, acc, target)) {
                    return true
                }
                acc[i] -= this[idx]
            }
        }
        return false
    }
}
