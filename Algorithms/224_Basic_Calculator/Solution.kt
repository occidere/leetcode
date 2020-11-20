import java.util.*

class Solution {
    fun calculate(s: String, stk: Stack<String> = Stack<String>()): Int = s.toExprList()
            .map {
                stk.push(if (it != ")") it else stk.eval().toString())
                stk
            }.last()
            .eval()

    private fun String.toExprList(): List<String> {
        val sb = StringBuilder()
        val expr = mutableListOf<String>()
        for (c in this) when (c) {
            in '0'..'9' -> sb.append(c)
            '(', ')', '+', '-' -> {
                expr += listOf(sb.toString(), c.toString())
                sb.clear()
            }
        }
        return (expr + sb.toString()).filter { it.isNotEmpty() }
    }

    private fun Stack<String>.eval(): Int {
        val sb = StringBuilder()
        while (this.isNotEmpty()) {
            val e = this.pop()
            if (e != "(") sb.insert(0, e) else break
        }
        return sb.toString()
                .replace("--", "+")
                .replace("-", "+-")
                .split("+")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .sum()
    }
}