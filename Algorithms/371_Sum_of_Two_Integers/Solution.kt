/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-09
 */
class Solution {
    fun getSum(a: Int, b: Int): Int {
        val (aBytes, bBytes) = a.toBinStr() to b.toBinStr()
        var carry = 0
        val res = IntArray(32) { 0 }
        for (i in 31.downTo(0)) {
            res[i] = when (aBytes[i] to bBytes[i]) {
                '1' to '1', '0' to '0' -> {
                    val ret = carry
                    carry = aBytes[i] - '0'
                    ret
                }
                else -> if (carry == 1) 0 else {
                    carry = 0
                    1
                }
            }
        }
        return res.joinToString("")
            .toLong(2)
            .toInt()
    }

    private fun Int.toBinStr() = Integer.toBinaryString(this)
        .let { (1..(32 - it.length)).joinToString("") { "0" } + it }
}
