/**
 * Ref: https://me2.do/GyyhVy6F
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-09
 */
class Solution {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith(Comparator { xs, ys -> if (xs[0] == ys[0]) ys[1] - xs[1] else xs[0] - ys[0] })
        var maxVal = Int.MIN_VALUE
        var res = 0
        for (i in properties.indices.reversed()) {
            if (properties[i][1] < maxVal) {
                ++res
            }
            maxVal = kotlin.math.max(maxVal, properties[i][1])
        }
        return res
    }
}
