class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> = l.zip(r)
            .map { nums.slice(it.first..it.second).sorted() }
            .map { it.zip(it.slice(1 until it.size)) }
            .map { xs -> xs.map { it.first - it.second }.distinct().count() == 1 }
}