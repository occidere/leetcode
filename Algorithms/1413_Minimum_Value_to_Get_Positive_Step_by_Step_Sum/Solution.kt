/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-24
 */
class Solution {
    fun minStartValue(nums: IntArray): Int {
        var (minVal, acc) = 0x3f3f3f3f to 0
        for (n in nums) {
            acc += n
            if (acc < minVal) {
                minVal = acc
            }
        }
        return if (minVal < 0) 1 - minVal else 1
    }
}
