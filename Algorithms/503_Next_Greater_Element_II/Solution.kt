class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        fun Int.getNext(): Int = (this + 1) % nums.size
        return nums.indices.map {
            val num = nums[it]
            var i = it.getNext()
            var ret = -1
            while (i != it) {
                if (num < nums[i]) {
                    ret = nums[i]
                    break
                }
                i = i.getNext()
            }
            ret
        }.toIntArray()
    }
}