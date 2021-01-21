import java.util.*

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray = Stack<Int>().also {
        it.push(nums.first())
        for (i in 1 until nums.size) {
            while (it.isNotEmpty()) {
                if (nums.size - 1 - i < k - it.size) break // Stop if left nums count is smaller than subsequence count
                else if (it.peek() > nums[i]) it.pop()
                else break
            }
            it.push(nums[i])
        }
    }.take(k).toIntArray()
}