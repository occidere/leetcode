class Solution {
    fun isNumber(s: String): Boolean {
        val str = s.toLowerCase()
        var (digit, exponent, dot) = Triple(false, false, false)
        for (i in str.indices) {
            val c = str[i]
            if (c.isDigit()) {
                digit = true
            } else if (c == '+' || c == '-') {
                if (i > 0 && str[i - 1] != 'e') {
                    return false
                }
            } else if (c == 'e') {
                if (exponent || !digit) {
                    return false
                }
                exponent = true
                digit = false
            } else if (c == '.') {
                if (dot || exponent) {
                    return false
                }
                dot = true
            } else {
                return false
            }
        }
        return digit
    }
}
