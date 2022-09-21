/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-21
 */
class Solution {
    fun minBitFlips(start: Int, goal: Int) = Integer.toBinaryString(start.xor(goal))
        .map { it - '0' }
        .sum()
}
