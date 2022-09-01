/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-01
 */
class SummaryRanges {
    private val ranges = mutableListOf<Int>()
    private var intervals = arrayOf<IntArray>()
    private var compressed = true

    fun addNum(`val`: Int) {
        val pos = ranges.binarySearch(`val`)
        if (pos < 0) {
            ranges.addAll(-pos - 1, listOf(`val`, `val`))
            compressed = false
        }
    }

    fun getIntervals() = if (compressed) intervals else {
        val del = 1.until(ranges.size)
            .flatMap { i -> if (ranges[i - 1] == ranges[i] - 1) setOf(i - 1, i) else emptySet() }
            .toSet()
        intervals = ranges.indices
            .filter { !del.contains(it) }
            .map { ranges[it] }
            .run { indices.step(2).map { intArrayOf(this[it], this[it + 1]) } }
            .toTypedArray()
        compressed = true
        intervals
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * var obj = SummaryRanges()
 * obj.addNum(`val`)
 * var param_2 = obj.getIntervals()
 */
