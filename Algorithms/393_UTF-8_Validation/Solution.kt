/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-13
 */
class Solution {
    fun validUtf8(data: IntArray): Boolean {
        val bins = data.map { Integer.toBinaryString(it) }
            .map { b -> (0 until 8 - b.length).joinToString("") { "0" } + b }
        var i = 0
        while (i < bins.size) {
            val cnt = bins[i].takeWhile { it == '1' }.count()
            when {
                cnt == 0 -> ++i
                cnt > 4 -> return false
                else -> if (bins.isValid(i + 1, i + cnt)) {
                    i += cnt
                } else {
                    return false
                }
            }
        }
        return true
    }

    private fun List<String>.isValid(begin: Int, end: Int): Boolean {
        return end <= size &&
                !this[begin - 1].startsWith("10") &&
                subList(begin, end).all { it.startsWith("10") }
    }
}
