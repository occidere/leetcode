/**
 * @author occidere
 * @since 2019-05-30
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        val len = height.size
        for (i in 0 until len - 1) {
            for (j in i + 1 until len) {
                val w = j - i
                val h = Math.min(height[i], height[j])
                max = Math.max(max, w * h)
            }
        }
        return max
    }
}
