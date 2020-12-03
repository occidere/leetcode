class Solution {
    fun findContestMatch(n: Int): String {
        var seq: Array<String> = (1..n).map { it.toString() }.toTypedArray()
        var k = n
        while (k > 1) {
            seq = 0.until(seq.size shr 1)
                .map { "(${seq[it]},${seq[seq.size - it - 1]})" }
                .toTypedArray()
            k = k shr 1
        }
        return seq.first()
    }
}