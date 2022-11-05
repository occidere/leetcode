/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-03
 */
class Solution {
    fun twoEggDrop(n: Int): Int {
        var (f, d) = n to 0
        while (d + 1 < f) {
            f -= ++d
        }
        return d + 1
    }
}
