/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-27
 */
class Solution {
    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        var maxOverlapped = getMaxOverlapped(img1, img2)

        img1.forEach { it.reverse() }
        img2.forEach { it.reverse() }
        maxOverlapped = kotlin.math.max(maxOverlapped, getMaxOverlapped(img1, img2))

        img1.reverse()
        img2.reverse()
        maxOverlapped = kotlin.math.max(maxOverlapped, getMaxOverlapped(img1, img2))

        img1.forEach { it.reverse() }
        img2.forEach { it.reverse() }
        maxOverlapped = kotlin.math.max(maxOverlapped, getMaxOverlapped(img1, img2))

        return maxOverlapped
    }

    private fun getMaxOverlapped(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        var maxOverlapped = 0
        for (i in img1.indices) {
            for (j in img1[0].indices) {
                maxOverlapped = kotlin.math.max(maxOverlapped, getOverlapped(img1, img2, i, j))
            }
        }
        return maxOverlapped
    }

    private fun getOverlapped(img1: Array<IntArray>, img2: Array<IntArray>, x: Int, y: Int): Int {
        var overlapped = 0
        for (i in x until img2.size) {
            for (j in y until img2.size) {
                if (img1[i - x][j - y] == 1 && img2[i][j] == 1) {
                    ++overlapped
                }
            }
        }
        return overlapped
    }
}
