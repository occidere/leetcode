import java.util.*

class Solution {
    fun minAddToMakeValid(s: String) = Stack<Char>().let {
        s.forEach { c ->
            if (c == ')')
                if (it.isNotEmpty() && it.peek() == '(')
                    it.pop()
                else it.push(c)
            else
                it.push(c)
        }
        it.size
    }
}
