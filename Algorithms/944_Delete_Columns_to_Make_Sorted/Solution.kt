class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var cnt = 0
        for (i in strs[0].indices) {
            var (isSorted, prev) = true to 0
            for (j in strs.indices) {
                val cur = strs[j][i].toInt()
                if (prev > cur) {
                    isSorted = false
                    break
                } else {
                    prev = cur
                }
            }
            if (!isSorted) {
                ++cnt
            }
        }
        return cnt
    }
}
