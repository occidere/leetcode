/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-22
 */
class Solution {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        num.reverse()
        val added = mutableListOf<Int>()
        val kArr = k.toString()
            .toCharArray()
            .map { it - '0' }
            .reversed()
            .toIntArray()
        var carry = 0
        for (i in 0 until kotlin.math.max(num.size, kArr.size)) {
            val (a, b) = (if (i < num.size) num[i] else 0) to (if (i < kArr.size) kArr[i] else 0)
            added.add((a + b + carry) % 10)
            carry = (a + b + carry) / 10
        }
        if (carry > 0) {
            added.add(carry)
        }
        return added.reversed()
    }
}
