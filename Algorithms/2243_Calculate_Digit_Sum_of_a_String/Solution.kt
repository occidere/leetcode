/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-27
 */
class Solution {
    fun digitSum(s: String, k: Int): String {
        var str = s
        while (k < str.length) {
            val group = str.groupBySize(k)
            str = group.joinToString("") { "${it.sumBy { c -> c - '0' }}" }
        }
        return str
    }

    private fun String.groupBySize(k: Int): List<String> {
        val group = mutableListOf<String>()
        for (i in indices step k) {
            group.add(substring(i, kotlin.math.min(i + k, length)))
        }
        return group
    }
}
