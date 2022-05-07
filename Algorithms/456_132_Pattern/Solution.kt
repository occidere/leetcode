import java.util.*

class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        val stk = Stack<Int>()
        var thirdNum = Int.MIN_VALUE
        for (i in nums.indices.reversed()) {
            val firstNum = nums[i]
            if (stk.isNotEmpty() && firstNum < thirdNum) {
                return true
            }
            while (stk.isNotEmpty() && firstNum > stk.peek()) {
                thirdNum = stk.pop()
            }
            stk.push(firstNum)
        }

        return false
    }
}
