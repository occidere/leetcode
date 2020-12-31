import java.util.*

class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean =
        Stack<Int>().also {
            var i = 0
            for (element in pushed) {
                it.push(element)
                while (it.isNotEmpty() && it.peek() == popped[i]) {
                    it.pop()
                    ++i
                }
            }
        }.isEmpty()
}