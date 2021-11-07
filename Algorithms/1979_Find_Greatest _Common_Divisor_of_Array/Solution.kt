class Solution {
    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    fun findGCD(nums: IntArray) = gcd(nums.max()!!, nums.min()!!)
}
