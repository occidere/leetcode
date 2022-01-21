import kotlin.math.max

// 참고: https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/discuss/532538/JavaC++Python-Straight-Forward-O(1)-Space
class Solution {
    fun numTimesAllBlue(flips: IntArray): Int {
        var (count, right) = 0 to 0
        for (i in flips.indices) {
            right = max(right, flips[i])
            if (right == i + 1) {
                ++count
            }
        }
        return count
    }
}
