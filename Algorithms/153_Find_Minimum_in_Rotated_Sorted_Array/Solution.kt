import kotlin.math.*

class Solution {
    fun findMin(nums: IntArray) =
        if (nums.size == 1) nums.first() else nums.bSearch(0, nums.size - 1)

    private fun IntArray.bSearch(left: Int, right: Int): Int = if (left > right) Int.MAX_VALUE else {
        val mid = (left + right).shr(1)
        if (first() < last() && mid == 0) first()
        else {
            val (prev, cur, next) = Triple(this[max(0, mid - 1)], this[mid], this[min(mid + 1, size - 1)])
            if (prev > cur) this[mid]
            else if (cur > next) this[mid + 1]
            else min(bSearch(left, mid - 1), bSearch(mid + 1, right))
        }
    }
}
