class Solution {
    fun minSteps(s: String, t: String): Int {
        val (sFreq, tFreq) = s.toFreq() to t.toFreq()
        var ans = 0
        for (k in sFreq.keys + tFreq.keys) {
            val (sv, tv) = sFreq.getOrDefault(k, 0) to tFreq.getOrDefault(k, 0)
            val maxV = kotlin.math.max(sv, tv)
            sFreq[k] = maxV
            tFreq[k] = maxV
            ans += kotlin.math.abs(sv - tv)
        }
        return ans
    }

    private fun String.toFreq() =
        groupBy({ it }, { 1 }).mapValues { it.value.size }.toMutableMap()
}
