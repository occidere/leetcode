class Solution {
    fun numberOfBeams(bank: Array<String>) = bank.map { it.count { it == '1' } }
        .filter { it != 0 }
        .zipWithNext()
        .map { it.first * it.second }
        .sum()
}
