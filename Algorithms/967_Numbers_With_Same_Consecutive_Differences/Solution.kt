/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-03
 */
class Solution {
    fun numsSameConsecDiff(n: Int, k: Int) =
        (1..9).flatMap { find(n, k, "$it") }
            .toIntArray()

    private fun find(n: Int, k: Int, strNum: String): List<Int> =
        if (strNum.length == n) listOf(strNum.toInt())
        else (0..9).filter { kotlin.math.abs(it - (strNum.last() - '0')) == k }
            .flatMap { find(n, k, "$strNum$it") }
}
