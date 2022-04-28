class Solution {
    fun findLonely(nums: IntArray) = nums.sorted().run {
        indices.map {
            val (prev, next) = Pair(
                if (it == 0) -2 else this[it - 1],
                if (it == size - 1) 1000002 else this[it + 1]
            )
            if (this[it] in prev + 2 until next - 1) this[it] else -1
        }.filter { it >= 0 }
    }
}
