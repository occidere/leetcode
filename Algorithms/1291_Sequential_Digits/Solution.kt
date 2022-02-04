class Solution {
    fun sequentialDigits(low: Int, high: Int) = "123456789".run {
        (1..9).flatMap { w ->
            (0..9 - w).map { i ->
                substring(i, i + w).toInt().let { if (it in low..high) it else 0 }
            }
        }
    }.filter { it != 0 }
}
