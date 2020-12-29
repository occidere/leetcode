import java.util.*

class Solution {
    fun reverseParentheses(s: String): String = Stack<String>().apply {
        s.forEach {
            this.push(
                if (it == ')') this.pops()
                else it.toString()
            )
        }
    }.pops()

    private fun Stack<String>.pops(): String = StringBuilder().also {
        while (this.isNotEmpty()) {
            val top = this.pop()
            if (top != "(") it.append(top) else break
        }
    }.reverse().toString()
}