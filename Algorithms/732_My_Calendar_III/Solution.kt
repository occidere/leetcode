/**
 * Ref: //me2.do/GYTk6pXy
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-07
 */
class MyCalendarThree() {
    private val ranges = sortedMapOf<Int, Int>().withDefault { 0 }

    fun book(start: Int, end: Int): Int {
        ranges[start] = ranges.getValue(start) + 1
        ranges[end] = ranges.getValue(end) - 1
        var (curOverlapped, maxOverlapped) = 0 to 0
        for (overlapped in ranges.values) {
            curOverlapped += overlapped
            maxOverlapped = kotlin.math.max(maxOverlapped, curOverlapped)
        }
        return maxOverlapped
    }
}
