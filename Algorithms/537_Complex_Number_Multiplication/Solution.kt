class Solution {
    fun complexNumberMultiply(num1: String, num2: String) = Pair(num1.toNumbers(), num2.toNumbers())
        .let { (xs, ys) ->
            xs.flatMap { x -> ys.map { y -> x * y } }
                .let { zs ->
                    zs.filterNot { it.isImaginary() } to zs.filter { it.isImaginary() }
                }
        }.let { (real, imaginary) ->
            "${real.reduced()}+${imaginary.reduced()}"
        }

    private fun Iterable<Number>.reduced() = reduce { acc, number -> acc + number }

    private fun String.toNumbers() = split("+").map { Number(it) }

    data class Number(val n: String) {
        private val real = n.toReal()
        private val iCount = n.count { it == 'i' }

        fun isImaginary() = iCount > 0

        private fun String.toReal() = replace("i", "").toInt()

        operator fun times(other: Number) = (real * other.real).let { x ->
            when (iCount + other.iCount) {
                0 -> Number("$x")
                1 -> Number("${x}i")
                else -> Number("${-x}")
            }
        }

        operator fun plus(other: Number) = (real + other.real).let { x ->
            when (iCount + other.iCount) {
                0 -> Number("$x")
                else -> Number("${x}i")
            }
        }

        override fun toString() = n
    }
}
