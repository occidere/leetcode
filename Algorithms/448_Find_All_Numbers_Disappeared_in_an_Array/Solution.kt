class Solution {
    fun findDisappearedNumbers(nums: IntArray) = (1..nums.size).toSet()
        .subtract(nums.toSet())
        .toList()
}
