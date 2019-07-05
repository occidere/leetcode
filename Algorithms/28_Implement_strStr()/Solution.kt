class Solution {
    fun strStr(haystack: String, needle: String): Int {
        return if (needle.isEmpty()) {
            0
        } else {
            val matchIndices = kmp(haystack, needle)
            if (matchIndices.isEmpty()) {
                -1
            } else {
                matchIndices[0]
            }
        }
    }

    private fun kmp(s: String, w: String): List<Int> {
        val matchIndex = mutableListOf<Int>()
        val fail = getFail(w)
        var j = 0
        for (i in 0 until s.length) {
            while (j > 0 && s[i] != w[j]) {
                j = fail[j - 1]
            }
            if (s[i] == w[j]) {
                if (j == w.length - 1) {
                    matchIndex.add(i - j)
                    j = fail[j]
                } else {
                    j++
                }
            }
        }
        return matchIndex
    }

    private fun getFail(w: String): IntArray {
        val fail = IntArray(w.length) { 0 }
        var j = 0
        for (i in 1 until w.length) {
            while (j > 0 && w[i] != w[j]) {
                j = fail[j - 1]
            }
            if (w[i] == w[j]) {
                fail[i] = ++j
            }
        }
        return fail
    }
}