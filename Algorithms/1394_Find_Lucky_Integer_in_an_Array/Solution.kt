/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-28
 */
class Solution {
    fun findLucky(arr: IntArray) = arr.groupBy { it }
        .asSequence()
        .filter { it.key == it.value.size }
        .map { it.key }
        .sorted()
        .lastOrNull() ?: -1
}
