/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-15
 */
class NumArray(private val nums: IntArray) {

    init {
        for (i in nums.indices) {
            if (i > 0) {
                nums[i] += nums[i - 1]
            }
        }
    }

    fun sumRange(left: Int, right: Int) = nums[right] - if (left == 0) 0 else nums[left - 1]

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
