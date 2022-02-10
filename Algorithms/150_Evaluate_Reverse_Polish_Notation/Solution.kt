import java.util.*

class Solution {
    fun evalRPN(tokens: Array<String>) = Stack<String>().run {
        tokens.forEach { t ->
            push(if (t.isOperator()) eval(b = pop(), a = pop(), ops = t) else t)
        }
        pop().toInt()
    }

    private fun String.isOperator() = this == "+" || this == "-" || this == "*" || this == "/"

    private fun eval(a: String, b: String, ops: String) = when (ops) {
        "+" -> a.toInt() + b.toInt()
        "-" -> a.toInt() - b.toInt()
        "*" -> a.toInt() * b.toInt()
        else -> a.toInt() / b.toInt() // div
    }.run { toString() }
}
