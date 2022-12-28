/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-27
 */
class Solution {
    fun isCircularSentence(sentence: String) =
        sentence.split(" ")
            .let { xs -> xs.indices.all { i -> xs[i].last() == xs[(i + 1) % xs.size].first() } }
}
