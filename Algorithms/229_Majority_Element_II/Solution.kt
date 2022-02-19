class Solution {

    /**
     * Variation of Boyer-Moore Majority Vote algorithm.
     * Ref: https://leetcode.com/problems/majority-element-ii/discuss/63537/My-understanding-of-Boyer-Moore-Majority-Vote
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun majorityElement(nums: IntArray): List<Int> {
        var (count1, count2) = 0 to 0
        var (candidate1, candidate2) = 0 to 0

        for (num in nums) {
            if (candidate1 == num) {
                candidate1 = num
                ++count1
            } else if (candidate2 == num) {
                candidate2 = num
                ++count2
            } else if (count1 == 0) {
                candidate1 = num
                ++count1
            } else if (count2 == 0) {
                candidate2 = num
                ++count2
            } else {
                --count1
                --count2
            }
        }
        return sequenceOf(candidate1, candidate2).distinct()
            .filter { c -> println(c); nums.count { it == c } > nums.size / 3 }
            .toList()
    }

    /**
     * My Initial solution
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
//    fun majorityElement(nums: IntArray): List<Int> {
//        return nums.groupBy { it }
//            .filter { it.value.size > nums.size / 3 }
//            .keys
//            .toList()
//    }
}
