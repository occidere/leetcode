/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-06
 */
class Solution {
    fun checkRecord(s: String) =
        s.count { it == 'A' } < 2 && !s.contains("LLL")
}
