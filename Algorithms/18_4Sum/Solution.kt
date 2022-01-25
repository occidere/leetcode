class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableSetOf<List<Int>>()

        for (a in 0 until nums.size - 3) {
            for (b in a + 1 until nums.size - 2) {
                var (left, right) = b + 1 to nums.size - 1
                while (left < right) {
                    val selected = listOf(a, b, left, right).map { nums[it] }
                    val acc = selected.sum()
                    if (acc == target) {
                        res += selected

                        // Skipping same values through left -> right
                        ++left
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left
                        }

                        // Skipping same values through left <- right
                        --right
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right
                        }
                    } else if (acc > target) {
                        --right
                    } else {
                        ++left
                    }
                }
            }
        }
        return res.toList()
    }
}
