class Solution {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        piles.sort()
        var (minK, minTimes) = piles.last() to piles.last()
        var (left, right) = 0 to minTimes
        while (left <= right) {
            val k = (left + right).shr(1)
                .let { if (it == 0) 1 else it }
            val times = piles.getTimes(k)
            if (times <= h && k < minK) {
                kotlin.math.min(times, minTimes)
                minK = k
                right = k - 1
            } else {
                left = k + 1
            }
        }
        return minK
    }

    private fun IntArray.getTimes(k: Int): Int {
        val beforePileCount = binarySearch(k, 0, size)
            .let { if (it < 0) -(it + 1) else it + 1 }
        var times = beforePileCount
        for (i in beforePileCount until size) {
            times += this[i] / k + if (this[i] % k != 0) 1 else 0
        }
        return times
    }
}
