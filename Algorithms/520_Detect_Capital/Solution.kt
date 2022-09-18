/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-18
 */
class Solution {
    fun detectCapitalUse(word: String) = word.all { it.isUpperCase() } ||
            word.all { it.isLowerCase() } ||
            (word.first().isUpperCase() && word.drop(1).all { it.isLowerCase() })
}
