/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-12
 */
class Solution {
    fun findArray(pref: IntArray) = (listOf(0) + pref.toList())
        .zipWithNext()
        .map { it.first.xor(it.second) }
        .toIntArray()
}
