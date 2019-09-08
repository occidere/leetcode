class Solution {
    fun majorityElement(nums: IntArray): Int {
        val freq = HashMap<Int, Int>()
        nums.forEach { it -> freq.merge(it, 1, Integer::sum) }
        val k = nums.size / 2
        for (f in freq) {
            if (f.value > k) {
                return f.key
            }
        }
        return 0
    }
}
