/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-20
 */
class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>) = s.toList()
        .zip(s.indices)
        .groupBy({ it.first }, { it.second })
        .run {
            words.filter { it.length <= s.length }
                .count { it.isSubsequenceOf(this) }
        }

    private fun String.isSubsequenceOf(sPos: Map<Char, List<Int>>): Boolean {
        var prev = -1
        for (c in this) {
            if (c !in sPos) {
                return false
            }
            val (pos, next) = sPos[c]!!.let { it to it.upperBound(prev) }
            if (next == pos.size) {
                return false
            }
            prev = pos[next]
        }
        return true
    }

    private fun List<Int>.upperBound(target: Int): Int {
        var (left, right) = 0 to size
        while (left < right) {
            val mid = (left + right).shr(1)
            if (this[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return right
    }
}
