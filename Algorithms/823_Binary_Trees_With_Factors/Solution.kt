class Solution {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val sorted = arr.sorted()
        val dp = sorted.fold(mutableMapOf<Int, Long>().withDefault { 0 }) { acc, i -> acc[i] = 1; acc }
        val inf: Long = 1000000007
        return sorted.indices.map { i ->
            val parent = sorted[i]
            for (j in 0 until i) {
                val left = sorted[j]
                if (parent % left == 0) {
                    dp[parent] = dp[parent]!! + dp[left]!! * dp.getValue(parent / left) % inf
                }
            }
            dp[parent]!!
        }.sum().let { it % inf }.toInt()
    }
}