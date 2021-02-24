class Solution {
    fun scoreOfParentheses(S: String): Int = java.util.Stack<String>().apply {
        S.forEach {
            if (it == '(') push("(") else {
                var score = 1
                while (isNotEmpty()) {
                    val top = pop()
                    if (top == "(") break else score = top.toInt() shl 1
                }
                push("$score")

                var subTotal = 0
                while (isNotEmpty() && peek() != "(") {
                    subTotal += pop().toInt()
                }
                push("$subTotal")
            }
        }
    }.sumBy { it.toInt() }
}