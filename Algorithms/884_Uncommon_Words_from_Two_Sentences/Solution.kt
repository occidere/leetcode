/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-30
 */
class Solution {
    fun uncommonFromSentences(s1: String, s2: String) = "$s1 $s2".split(" ")
        .groupBy { it }
        .filter { it.value.size == 1 }
        .keys
        .toTypedArray()
}
