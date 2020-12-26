class Solution {
    fun wiggleSort(nums: IntArray) {
        // asc sort (insertion sort)
        val n = nums.size
        for (i in 1 until n) {
            val key = nums[i]
            var j = i - 1
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j--]
            }
            nums[j + 1] = key
        }

        // wiggle sort
        for (i in 1 until n - 1 step 2) {
            val tmp = nums[i]
            nums[i] = nums[i + 1]
            nums[i + 1] = tmp
        }
    }
}