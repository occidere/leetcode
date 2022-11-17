/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-17
 */
class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String) = sentence.split(" ")
        .asSequence()
        .withIndex()
        .filter { (_, v) -> v.startsWith(searchWord) }
        .map { it.index + 1 }
        .min() ?: -1
}
