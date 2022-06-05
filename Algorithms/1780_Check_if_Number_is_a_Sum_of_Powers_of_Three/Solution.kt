import kotlin.math.pow

class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        val powerOfThrees = (0..14).map { 3f.pow(it).toInt() }
            .filter { it <= n }
            .toTypedArray()

        fun dfs(idx: Int, acc: Int): Boolean =
            if (acc >= n) acc == n
            else (idx + 1).until(powerOfThrees.size)
                .any { dfs(it, acc + powerOfThrees[it]) }

        return dfs(-1, 0)
    }
}
