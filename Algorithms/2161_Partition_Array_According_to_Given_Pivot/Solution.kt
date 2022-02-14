class Solution {
    fun pivotArray(nums: IntArray, pivot: Int) =
        (nums.filter { it < pivot } + nums.filter { it == pivot } + nums.filter { it > pivot }).toIntArray()
}
