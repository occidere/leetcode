class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int = gas.zip(cost)
            .map { it.first - it.second }
            .toIntArray()
            .let { gas.indices.find { i -> it.isPossible(i) } ?: -1 }

    private fun IntArray.isPossible(start: Int): Boolean {
        var gas = 0
        return start.until(start + this.size)
                .map { gas += this[it % this.size]; gas >= 0 }
                .reduce { acc, b -> acc && b }
    }
}