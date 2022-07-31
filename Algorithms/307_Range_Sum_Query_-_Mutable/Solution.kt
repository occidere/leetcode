/**
 * Ref: https://me2.do/xPQWwBXy
 *
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-07-31
 */
class NumArray(nums: IntArray) {

    private val n = nums.size
    private val tree = IntArray(n.shl(1)) { 0 }

    init {
        var (i, j) = n to 0
        while (i < n.shl(1)) {
            tree[i++] = nums[j++]
        }
        for (k in nums.indices.reversed()) {
            tree[k] = tree[k.shl(1)] + tree[k.shl(1) + 1]
        }
    }

    fun update(index: Int, `val`: Int) {
        var newIdx = index + n
        tree[newIdx] = `val`

        while (newIdx > 0) {
            var (left, right) = newIdx to newIdx
            if (newIdx % 2 == 0) {
                right = newIdx + 1
            } else {
                left = newIdx - 1
            }
            tree[newIdx.shr(1)] = tree[left] + tree[right]
            newIdx = newIdx.shr(1)
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        var (l, r) = left + n to right + n
        var sum = 0
        while (l <= r) {
            if (l % 2 == 1) {
                sum += tree[l++]
            }
            if (r % 2 == 0) {
                sum += tree[r--]
            }
            l = l.shr(1)
            r = r.shr(1)
        }
        return sum
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */
