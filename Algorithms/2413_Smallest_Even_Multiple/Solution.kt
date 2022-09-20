/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-20
 */
class Solution {
    fun smallestEvenMultiple(n: Int) = if (n % 2 == 0) n else n.shl(1)
//    fun smallestEvenMultiple(n: Int) = lcm(2, n)
//
//    private fun lcm(a: Int, b: Int) = (a * b) / gcd(a, b)
//
//    private fun gcd(a: Int, b: Int): Int {
//        var (x, y, z) = Triple(a, b, 0)
//        while (y != 0) {
//            z = x % y
//            x = y
//            y = z
//        }
//        return x
//    }
}
