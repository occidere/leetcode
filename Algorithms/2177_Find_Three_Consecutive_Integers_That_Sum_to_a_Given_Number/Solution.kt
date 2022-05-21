class Solution {
    fun sumOfThree(num: Long) =
        if (num % 3L == 0L) longArrayOf(num / 3L - 1, num / 3L, num / 3L + 1) else longArrayOf()
}
