/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-05
 */
class Solution {
    fun nextGreaterElement(n: Int): Int {
        val (nl, cs) = n.toLong() to n.toString().toMutableList()
        var (changed, minVal) = true to Long.MAX_VALUE
        while (changed) {
            changed = false
            outer@ for (i in cs.size - 2 downTo 0) {
                for (j in cs.size - 1 downTo i + 1) {
                    cs.swap(i, j)
                    val m = cs.joinToString("").toLong()
                    if (m in (nl + 1) until minVal) {
                        changed = true
                        minVal = m
                        continue@outer
                    }
                    cs.swap(j, i)
                }
            }
        }
        return if (minVal == nl || Int.MAX_VALUE < minVal) -1 else minVal.toInt()
    }

    private fun MutableList<Char>.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}
