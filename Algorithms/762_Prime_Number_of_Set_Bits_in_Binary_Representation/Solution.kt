/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-03
 */class Solution {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        return (left..right)
            .map { Integer.toBinaryString(it) }
            .map { b -> b.count { it == '1' } }
            .count { it.isPrime() }
    }

    private fun Int.isPrime(): Boolean {
        if (this < 2) {
            return false
        }
        for (i in 2 until this) {
            if (this % i == 0) {
                return false
            }
        }
        return true
    }
}
