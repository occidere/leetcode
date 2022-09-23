import kotlin.math.abs

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-23
 */
class Solution {
    fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int) = 0.until(rows)
        .flatMap { i ->
            0.until(cols)
                .map { j ->
                    (abs(i - rCenter) + abs(j - cCenter) to intArrayOf(i, j))
                }
        }.sortedBy { it.first }
        .map { it.second }
        .toTypedArray()
}
