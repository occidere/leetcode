/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-02
 */
class Solution {
    fun countVowelSubstrings(word: String) =
        (5..word.length).flatMap { w ->
            (w..word.length).filter {
                "aeiou" == word.substring(it - w, it)
                    .toSortedSet()
                    .joinToString("")
            }
        }.count()
}
