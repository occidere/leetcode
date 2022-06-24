class Solution {
    fun reinitializePermutation(n: Int): Int {
        var perm = (0 until n).map { it }.toIntArray()
        var cnt = 0
        while (true) {
            ++cnt
            val arr = IntArray(n) { 0 }
            for (i in perm.indices) {
                arr[i] = if (i % 2 == 0) perm[i.shr(1)] else perm[n.shr(1) + (i - 1).shr(1)]
            }
            perm = arr
            if (perm.isOriginPerm()) {
                break
            }
        }
        return cnt
    }

    private fun IntArray.isOriginPerm(): Boolean {
        for (i in 1 until size) {
            if (this[i] - this[i - 1] != 1) {
                return false
            }
        }
        return true
    }
}
