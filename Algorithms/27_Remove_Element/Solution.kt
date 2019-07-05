class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
	var idx = 0
	for (i in 0 until nums.size) {
	    if (nums[i] != `val`) {
	        nums[idx++] = nums[i]
	    }
	}
	return idx
    }
}
