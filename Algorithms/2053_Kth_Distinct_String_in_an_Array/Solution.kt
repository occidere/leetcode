class Solution {
    fun kthDistinct(arr: Array<String>, k: Int) = arr.groupBy { it }
        .map { it.key to it.value.size }
        .filter { it.second == 1 }
        .let { if (it.size < k) "" else it[k - 1].first }
}
