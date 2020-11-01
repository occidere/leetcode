class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean = if (intervals.size < 2) true else
        !intervals.sortedWith(Comparator { a, b -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] })
                .zipWithNext()
                .map { it.first[1] > it.second[0] }
                .reduce { acc, e -> acc || e }
}