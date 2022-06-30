import kotlin.math.abs

// Ref: https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution
class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int) = if (numerator == 0) "0" else {
        var (n, d) = abs(numerator.toLong()) to abs(denominator.toLong())
        val ret = mutableListOf(
            if (numerator < 0 && denominator < 0 || numerator > 0 && denominator > 0) "" else "-",
            "${n / d}"
        )
        n %= d

        if (n == 0L) ret.joinToString("") else {
            ret.add(".")

            val repeatMap = mutableMapOf(n to ret.size)
            while (n > 0L) {
                n *= 10
                ret.add("${n / d}")
                n %= d
                if (repeatMap.contains(n)) {
                    ret.add(repeatMap[n]!!, "(")
                    ret.add(")")
                    break
                } else {
                    repeatMap[n] = ret.size
                }
            }
            ret.joinToString("")
        }
    }
}
