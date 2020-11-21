class Solution {
    fun largestNumber(nums: IntArray): String = nums.map { it.toString() }
            .sortedWith(Comparator { a, b -> (b + a).compareTo(a + b) })
            .joinToString("")
            .let {
                0.until(it.length - 1)
                        .takeWhile { i -> it[i] == '0' }
                        .lastOrNull()
                        ?.let { i -> it.substring(i + 1, it.length) }
                        ?: it
            }
}