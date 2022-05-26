class Solution {
    fun numberOfSubstrings(s: String) = intArrayOf(-1, -1, -1).run {
        s.indices.map {
            this[s[it] - 'a'] = it
            getCount()
        }.sum()
    }

    private fun IntArray.getCount() = if (this[0] >= 0 && this[1] >= 0 && this[2] >= 0) min()!! + 1 else 0
}
