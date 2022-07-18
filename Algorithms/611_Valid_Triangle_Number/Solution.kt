/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-18
 */
class Solution {
    fun triangleNumber(nums: IntArray) = if (nums.size < 3) 0 else nums.sorted()
        .run {
            0.until(size - 2).flatMap { i ->
                (i + 1).until(size - 1).map { j ->
                    upperBound(i, j) - j - 1
                }
            }.sum()
        }

    private fun List<Int>.upperBound(a: Int, b: Int): Int {
        var (left, right) = b + 1 to size
        while (left < right) {
            val mid = (left + right).shr(1)
            if (this[mid] < this[a] + this[b]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
