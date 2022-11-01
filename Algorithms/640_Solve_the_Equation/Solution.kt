/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-01
 */
class Solution {
    fun solveEquation(equation: String): String {
        val (xs, nums) = equation.split('=')
            .let { it[0].toSigned().calc() to it[1].toSigned().calc() }
            .let { (left, right) -> left.first - right.first to right.second - left.second }
            .run { if (first < 0) -first to -second else first to second }
        return if (xs == 0) {
            if (nums == 0) "Infinite solutions"
            else "No solution"
        } else if (nums == 0) {
            "x=0"
        } else if (xs == 1) {
            "x=$nums"
        } else {
            val gcd = kotlin.math.abs(gcd(xs, nums))
            if (gcd == 1) "${xs}x=$nums"
            else {
                if (xs / gcd == 1) "x=${nums / gcd}"
                else "${xs / gcd}x=${nums / gcd}"
            }
        }
    }

    private fun String.toSigned() = if (this[0] == '+' || this[0] == '-') this else "+$this"

    private fun String.calc(): Pair<Int/*x*/, Int/*num*/> {
        var (xs, nums, sign) = Triple(0, 0, this[0])
        val vars = mutableListOf<Char>()
        for (c in drop(1)) {
            when (c) {
                '+', '-' -> {
                    evalExpr(sign, vars).run {
                        xs += first
                        nums += second
                    }
                    sign = c
                    vars.clear()
                }

                'x' -> {
                    if (vars.isEmpty()) {
                        vars.add('1')
                    }
                    vars.add(c)
                }

                else -> vars.add(c)
            }
        }
        return evalExpr(sign, vars).run {
            xs + first to nums + second
        }
    }

    private fun evalExpr(sign: Char, vars: MutableList<Char>): Pair<Int, Int> {
        val k = vars.joinToString("")
        return if (k.last() == 'x') Pair(k.dropLast(1).calcAsInt(sign), 0) else Pair(0, k.calcAsInt(sign))
    }

    private fun String.calcAsInt(sign: Char) = (if (sign == '+') 1 else -1) * toInt()

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
