class Solution {
    fun countOdds(low: Int, high: Int) =
        ((if (high % 2 == 0) high - 1 else high) - (if (low % 2 == 0) low + 1 else low)).shr(1) + 1
}
