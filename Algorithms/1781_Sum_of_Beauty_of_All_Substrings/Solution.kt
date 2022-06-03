class Solution {
    fun beautySum(s: String): Int {
        var totalBeauty = 0
        for (i in s.indices) {
            val freq = IntArray(26) { 0 }
            freq[s[i] - 'a'] = 1
            for (j in i + 1 until s.length) {
                freq[s[j] - 'a'] += 1
                totalBeauty += freq.filter { it != 0 }
                    .sorted()
                    .let { it.last() - it.first() }
            }
        }
        return totalBeauty
    }
}
