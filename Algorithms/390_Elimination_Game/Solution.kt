class Solution {
    fun lastRemaining(n: Int): Int {
        val nums = intArrayOf(1, n)
        var (g, isReverse) = 2 to false
        while (nums[0] != nums[1]) {
            val prevG = g.shr(1)
            if (isReverse) {
                nums[0] += if (nums.hasCommonDivisorOf(g)) prevG else 0
                nums[1] -= prevG
            } else {
                nums[1] -= if (nums.hasCommonDivisorOf(g)) prevG else 0
                nums[0] += prevG
            }
            g = g.shl(1)
            isReverse = !isReverse
        }
        return nums[0]
    }

    private fun IntArray.hasCommonDivisorOf(g: Int) = first() % g == last() % g
}
