/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-11
 */
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>) = intervals.sortedBy { it.last() }
        .run {
            var (selected, end) = 1 to first()[1]
            for (itv in drop(1)) {
                if (end <= itv[0]) {
                    end = itv[1]
                    ++selected
                }
            }
            size - selected
        }
}
