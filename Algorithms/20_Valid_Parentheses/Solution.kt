import java.util.Stack

class Solution {
    private val pair: Map<Char, Char> = mapOf(')' to '(', '}' to '{', ']' to '[')

    fun isValid(s: String): Boolean {
        val stack: Stack<Char> = Stack()
        try {
            for (ch: Char in s) {
                if (pair.containsKey(ch)) {
                    if (pair.get(ch) != stack.pop()) {
        	        return false
                    }
                } else {
                    stack.add(ch)
                }
            }
        } catch (e: Exception) {
            return false
        }
        return stack.isEmpty()
    }
}
