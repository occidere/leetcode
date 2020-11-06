import java.util.*
import kotlin.math.max

class Solution {

    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var left = 0
        var right = 0
        var maxLen = 1
        val multiSet = MultiSet(nums[0])
        while (left <= right && left < nums.size) {
            if (multiSet.getMaxDiff() <= limit) {
                maxLen = max(maxLen, right - left + 1)
                if (right < nums.size - 1) multiSet.add(nums[++right]) else break
            } else {
                multiSet.remove(nums[left++])
            }
        }
        return maxLen
    }


    class MultiSet(vararg nums: Int) {

        private val cache = mutableMapOf<Int, Queue<MutablePair<Int, Boolean>>>()
        private val minQ = PriorityQueue<MutablePair<Int, Boolean>> { a, b -> a.first - b.first }
        private val maxQ = PriorityQueue<MutablePair<Int, Boolean>> { a, b -> b.first - a.first }

        init {
            nums.forEach { add(it) }
        }

        fun add(num: Int) {
            val p = MutablePair(num, true)
            cache.putIfAbsent(num, LinkedList())
            cache[num]!!.add(p)
            minQ.add(p)
            maxQ.add(p)
        }

        fun remove(num: Int) {
            cache[num]!!.poll().second = false
            while (!minQ.peek().second) minQ.poll()
            while (!maxQ.peek().second) maxQ.poll()
        }

        fun getMaxDiff(): Int = maxQ.peek().first - minQ.peek().first

        data class MutablePair<T, U>(var first: T, var second: U)
    }
}