/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-11
 */
class Solution {
    fun countSegments(s: String) = s.split(' ').filter { it.length != 0 }.size
}
