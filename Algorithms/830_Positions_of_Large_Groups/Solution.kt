/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-18
 */
class Solution {
    fun largeGroupPositions(s: String): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        var (left, right) = 0 to 0
        while (++right < s.length) {
            if (s[left] != s[right]) {
                if (3 <= right - left) {
                    res.add(listOf(left, right - 1))
                }
                left = right
            }
        }
        if (3 <= right - left) {
            res.add(listOf(left, right - 1))
        }
        return res
    }
}
