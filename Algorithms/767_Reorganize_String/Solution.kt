import java.util.*

class Solution {
    fun reorganizeString(S: String): String {
        val freq = S.groupBy { it }.toList().map { it.second }.sortedByDescending { it.size }
        val arr = Array(freq.size) { Array(freq[0].size) { '_' } }
        val q = LinkedList<Char>().apply { addAll(freq.flatten()) }
        for (i in arr.indices) {
            for (j in freq[0].indices) {
                arr[i][j] = q.poll() ?: break
            }
        }

        val buf = mutableListOf<Char>()
        for (i in freq[0].indices) {
            for (j in arr.indices) {
                buf += arr[j][i]
            }
        }

        val res = buf.filter { it != '_' }.joinToString("")
        for (i in 1 until res.length) {
            if (res[i - 1] == res[i]) {
                return ""
            }
        }
        return res
    }
}