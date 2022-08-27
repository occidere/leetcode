/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-27
 */
class Solution {
    fun countLargestGroup(n: Int) = (1..n).groupBy { it.toString().sumBy { c -> c - '0' } }
        .map { it.value.size }
        .groupBy { it }
        .maxBy { it.key }
        ?.value
        ?.size ?: -1
}
