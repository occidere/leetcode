class Solution {
    fun integerBreak(n: Int) = when (n) {
        2 -> 1
        3 -> 2
        else -> {
            var (num, prd) = Pair(n, 1)
            while (num > 4) {
                prd *= 3
                num -= 3
            }
            prd * num
        }
    }
}
