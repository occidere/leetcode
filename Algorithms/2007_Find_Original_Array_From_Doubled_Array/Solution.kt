import java.util.*

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-15
 */
class Solution {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 == 1) {
            return intArrayOf()
        }

        val targetSize = changed.size.shr(1)
        val res = mutableListOf<Int>()
        val freq = changed.groupBy { it }
            .mapValues { it.value.size }
            .toSortedMap()
        while (res.size < targetSize) {
            val smallest = freq.firstKey()
            if (!smallest.operate(freq)) {
                return intArrayOf()
            }
            val doubled = smallest.shl(1)
            if (!doubled.operate(freq)) {
                return intArrayOf()
            }
            res.add(smallest)
        }
        return res.toIntArray()
    }

    private fun Int.operate(freq: SortedMap<Int, Int>) =
        if (freq.getOrDefault(this, 0) > 0) {
            if (freq[this]!! == 1) {
                freq.remove(this)
            } else {
                freq[this] = freq[this]!! - 1
            }
            true
        } else false
}
