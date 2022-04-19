class Solution {
    fun memLeak(memory1: Int, memory2: Int): IntArray {
        val mem = intArrayOf(0, memory1, memory2)
        var time = 0L
        while (++time > 0) {
            val (avail1, avail2) = mem[1] - time to mem[2] - time
            mem[0] = time.toInt()
            if (0 <= avail1 && 0 <= avail2) mem[if (avail1 < avail2) 2 else 1] -= time.toInt()
            else if (0 <= avail1) mem[1] -= time.toInt()
            else if (0 <= avail2) mem[2] -= time.toInt()
            else break
        }
        return mem
    }
}
