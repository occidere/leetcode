class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return if (nums.isEmpty()) {
            -1
        } else {
            val extendedNums = nums + nums
            val len = nums.size
            var idx = -1
            for (i in 0 until len) {
                if (extendedNums[i] <= extendedNums[i + len - 1]) {
                    idx = extendedNums.binarySearch(target, i, i + len)
                    break
                }
            }
            return if (idx < 0) {
                -1
            } else {
                idx % len
            }
        }
    }
}
