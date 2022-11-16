/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-16
 */
class Solution {
    fun minOperations(nums: IntArray): Int {
        var (q, cnt) = nums.filter { it != 0 }.toList() to 0
        while (true) {
            val nextQ = mutableListOf<Int>()
            for (num in q) {
                num.shr(1).let { if (it != 0) nextQ.add(it) }
                cnt += num % 2
            }
            if (nextQ.isEmpty()) {
                break
            } else {
                q = nextQ
                ++cnt
            }
        }
        return cnt
    }
}
