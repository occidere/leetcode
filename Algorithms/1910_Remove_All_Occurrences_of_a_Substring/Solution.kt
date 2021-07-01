import java.util.*

class Solution {
    fun removeOccurrences(s: String, part: String): String = Stack<Char>().also { stk ->
        s.forEach { c ->
            stk.push(c)
            if (stk.size >= part.length) {
                stk.pops(part.length).run {
                    if (this != part) {
                        this.forEach { stk.push(it) }
                    }
                }
            }
        }
    }.joinToString("")

    private fun Stack<Char>.pops(n: Int): String = (1..n).map { this.pop() }
            .reversed()
            .joinToString("")
}
