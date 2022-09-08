/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-08
 */
class Solution {
    fun maxProduct(nums: IntArray): Int {
        return if (nums.size == 1) nums[0] else nums.splitByZero()
            .filter { it.isNotEmpty() }
            .map { it.getMaxProduct() }
            .max()!!
    }

    private fun IntArray.splitByZero(): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val nonZeros = mutableListOf<Int>()
        for (num in this) {
            if (num == 0) {
                ret.add(nonZeros.toList())
                nonZeros.clear()
            } else {
                nonZeros.add(num)
            }
        }
        return (ret + listOf(nonZeros))
    }

    private fun List<Int>.getMaxProduct(): Int {
        var numberOfMinus = 0
        var (firstMinusPos, lastMinusPos) = 0x3f3f3f3f to -1
        for (i in indices) {
            if (this[i] < 0) {
                ++numberOfMinus
                firstMinusPos = kotlin.math.min(firstMinusPos, i)
                lastMinusPos = kotlin.math.max(lastMinusPos, i)
            }
        }

        val product = { xs: List<Int> -> xs.ifEmpty { listOf(0) }.reduce { acc, i -> acc * i } }
        return if (numberOfMinus % 2 == 0) {
            product(this)
        } else {
            kotlin.math.max(product(subList(0, lastMinusPos)), product(subList(firstMinusPos + 1, size)))
        }
    }
}
