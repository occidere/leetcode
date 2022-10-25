/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-25
 */
class Solution {
    fun minMaxGame(nums: IntArray): Int {
        var xs = nums.toList()
        while (1 < xs.size) {
            val tmp = mutableListOf<Int>()
            for ((k, i) in (xs.indices step 2).withIndex()) {
                tmp.add(if (k % 2 == 0) kotlin.math.min(xs[i], xs[i + 1]) else kotlin.math.max(xs[i], xs[i + 1]))
            }
            xs = tmp
        }
        return xs[0]
    }
}
