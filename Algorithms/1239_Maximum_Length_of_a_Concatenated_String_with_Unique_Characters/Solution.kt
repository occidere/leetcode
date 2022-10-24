/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-24
 */
class Solution {
    fun maxLength(arr: List<String>): Int {
        val bits = arr.filter { it.hasUniqChars() }
            .map { it.toBits() }
        val isUniq = { x: Int, y: Int -> x.and(y) == 0 }
        var maxLen = 0
        fun dfs(idx: Int = 0, trace: Int = 0) {
            maxLen = kotlin.math.max(maxLen, trace.getBitLength())
            for (i in idx until bits.size) {
                if (isUniq.invoke(trace, bits[i])) {
                    dfs(i + 1, trace.or(bits[i]))
                }
            }
        }
        dfs()
        return maxLen
    }

    private fun String.hasUniqChars() = groupBy { it }.values.all { it.size == 1 }

    private fun String.toBits() = map { 1.shl(it - 'a') }.reduce { x, y -> x.or(y) }

    private fun Int.getBitLength() = Integer.toBinaryString(this).count { it == '1' }
}
