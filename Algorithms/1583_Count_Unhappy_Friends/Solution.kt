class Solution {
    fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
        val conn = IntArray(n) { 0 }
        for (p in pairs) {
            conn[p[0]] = p[1]
            conn[p[1]] = p[0]
        }

        var res = 0
        val prefMap = Array(n) { mutableMapOf<Int, Int>() }
        for (i in 0 until n) {
            for (j in 0 until n - 1) {
                prefMap[i][preferences[i][j]] = j
            }
        }

        for (i in 0 until n) {
            for (j in preferences[i]) {
                if (prefMap[j][i]!! < prefMap[j][conn[j]]!! && prefMap[i][conn[i]]!! > prefMap[i][j]!!) {
                    ++res
                    break
                }
            }
        }

        return res
    }
}
