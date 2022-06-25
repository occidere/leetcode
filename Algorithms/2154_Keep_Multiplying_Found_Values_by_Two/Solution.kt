class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var k = original
        val sets = nums.toSet()
        while (sets.contains(k)) {
            k = k.shl(1)
        }
        return k
    }
}
