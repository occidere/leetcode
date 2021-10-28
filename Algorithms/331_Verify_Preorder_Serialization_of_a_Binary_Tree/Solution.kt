import java.util.*

class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        val cs = preorder.split(',')
        if (cs.size == 1 && cs[0] == "#") {
            return true
        }
        val stk = Stack<Pair<String, Int>>().apply { push(cs[0] to 0) }
        for (c in cs.drop(1)) {
            if (stk.isEmpty()) {
                return false
            }
            stk.push(stk.pop().run { first to second + 1 })
            if (c != "#") {
                stk.push(c to 0)
            }
            while (stk.isNotEmpty() && stk.peek().second == 2) {
                val top = stk.pop()
                if (top.first == "#") {
                    return false
                }
            }
        }
        return stk.isEmpty()
    }
}
