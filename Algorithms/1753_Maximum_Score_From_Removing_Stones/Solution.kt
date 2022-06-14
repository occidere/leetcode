class Solution {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val scores = intArrayOf(a, b, c)
        var phase = 0
        while (true) {
            scores.sort()
            if (scores[0] == 0) {
                phase += kotlin.math.min(scores[1], scores[2])
                break
            }
            ++phase
            --scores[0]
            --scores[2]
        }
        return phase
    }
}
