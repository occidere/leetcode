/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-29
 */
class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        if (arr.any { it == 0 }) {
            val visit = mutableSetOf<Int>()
            val q = mutableListOf(start)
            while (q.isNotEmpty()) {
                val (curIdx, curVal) = q.removeAt(0).let { it to arr[it] }
                visit.add(curIdx)
                if (curVal == 0) {
                    return true
                }
                listOf(curIdx - curVal, curIdx + curVal)
                    .filter { it in arr.indices && !visit.contains(it) }
                    .forEach { q.add(it) }
            }
        }
        return false
    }
}
