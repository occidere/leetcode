/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-16
 */
class Solution {
    fun countPrefixes(words: Array<String>, s: String) = words.count { s.startsWith(it) }
}
