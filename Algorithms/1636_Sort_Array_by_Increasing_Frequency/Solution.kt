class Solution {
    fun frequencySort(nums: IntArray) = nums.groupBy { it }
        .map { it.key to it.value.size }
        .sortedWith(Comparator { x, y -> if (x.second == y.second) y.first - x.first else x.second - y.second })
        .flatMap { xs -> 0.until(xs.second).map { xs.first } }
        .toIntArray()
}
