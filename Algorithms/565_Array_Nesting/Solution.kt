class Solution {
    fun arrayNesting(nums: IntArray) = nums.indices.map {
        var (j, len) = it to 0
        while (nums[j] != -1) {
            j = nums[j].apply { nums[j] = -1 }
            ++len
        }
        len
    }.max()!!
}
