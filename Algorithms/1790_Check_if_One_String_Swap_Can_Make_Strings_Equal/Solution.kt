/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-07
 */
class Solution {
    fun areAlmostEqual(s1: String, s2: String) =
        s1 == s2 || (s1.toCharArray().sorted() == s2.toCharArray().sorted() && s1.indices.count { s1[it] != s2[it] } == 2)
}
