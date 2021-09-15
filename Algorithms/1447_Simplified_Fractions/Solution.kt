class Solution {
    fun simplifiedFractions(n: Int): List<String> {
        val fractions = mutableSetOf<String>()

        for (i in 2..n) {
            for (j in 1 until i) {
                simplify(j, i).run {
                    if (first != 0 && second != 0) {
                        fractions += "${first}/${second}"
                    }
                }
            }
        }

        return fractions.toList()
    }

    private fun simplify(a: Int, b: Int): Pair<Int, Int> {
        var (x, y) = a to b
        for (i in 2..a) {
            if (x % i == 0 && y % i == 0) {
                x %= i
                y %= i
            }
        }
        return x to y
    }
}
