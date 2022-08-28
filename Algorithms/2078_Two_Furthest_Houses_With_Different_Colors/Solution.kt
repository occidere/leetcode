/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-28
 */
class Solution {
    fun maxDistance(colors: IntArray): Int {
        var maxDist = 0
        for (i in colors.indices) {
            for (j in colors.indices) {
                if (colors[i] != colors[j]) {
                    maxDist = kotlin.math.max(maxDist, kotlin.math.abs(i - j))
                }
            }
        }
        return maxDist
    }
}
