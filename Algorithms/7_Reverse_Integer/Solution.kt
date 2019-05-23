class Solution {
    fun reverse(x: Int): Int {
        val num = ((if (x < 0) "-" else "") + x.toString().removePrefix("-").reversed()).toLong()
            return if (Int.MIN_VALUE <= num && num <= Int.MAX_VALUE) {
                num.toInt()
            } else {
                0
            }
    }
}
