/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-05
 */
class Solution {
    fun maximumSwap(num: Int): Int {
        val numArr = "$num".toCharArray()
        var maxVal = num
        for (i in numArr.indices) {
            for (j in i + 1 until numArr.size) {
                numArr.swap(i, j)
                maxVal = kotlin.math.max(maxVal, numArr.joinToString("").toInt())
                numArr.swap(i, j)
            }
        }
        return maxVal
    }

    private fun CharArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}
