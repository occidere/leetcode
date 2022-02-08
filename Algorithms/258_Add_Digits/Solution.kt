class Solution {
    fun addDigits(num: Int) = if (num < 10) num else if (num % 9 == 0) 9 else num % 9
}
