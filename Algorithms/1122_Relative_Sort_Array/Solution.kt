/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-08-25
 */
class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val map1 = arr1.groupBy { it }
            .mapValues { it.value.size }
            .toSortedMap()
        val res = mutableListOf<Int>()
        for (n in arr2) {
            repeat(map1[n]!!) {
                res.add(n)
            }
            map1[n] = 0
        }
        for ((k, v) in map1) {
            repeat(v) {
                res.add(k)
            }
        }
        return res.toIntArray()
    }
}
