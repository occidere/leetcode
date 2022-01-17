class RLEIterator(encoding: IntArray) {

    private var idx = 0
    private val enc = encoding.indices
        .step(2)
        .map { intArrayOf(encoding[it], encoding[it + 1]) }
        .filter { it[0] != 0 }

    fun next(n: Int): Int {
        var k = n
        while (isValidIdx() && k > enc[idx][0]) {
            k -= enc[idx++][0]
        }

        return if (isValidIdx()) enc[idx][1].apply {
            enc[idx][0] -= k
            if (enc[idx][0] == 0) {
                ++idx
            }
        } else -1
    }

    private fun isValidIdx() = idx < enc.size
}
