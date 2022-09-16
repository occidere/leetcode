/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-16
 */
class Solution {
    fun partitionString(s: String): Int {
        var (visit, count) = 0 to 1
        for (i in s.map { it - 'a' + 1 }) {
            if (visit.and(1.shl(i)) != 0) {
                visit = 0
                ++count
            }
            visit = visit.xor(1.shl(i))
        }
        return count
    }
}
