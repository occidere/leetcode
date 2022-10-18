/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-18
 */
class Solution {
    fun trimMean(arr: IntArray) = arr.sorted()
        .run { subList((size * 0.05).toInt(), size - (size * 0.05).toInt()) }
        .average()
}
