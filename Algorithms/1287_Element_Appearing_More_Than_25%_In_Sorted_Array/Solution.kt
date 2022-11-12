/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-12
 */
class Solution {
    fun findSpecialInteger(arr: IntArray) = arr.groupBy { it }
        .asSequence()
        .map { it.key to it.value.size }
        .maxBy { it.second }!!
        .first
}
