/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-25
 */
class Solution {
    fun answerQueries(nums: IntArray, queries: IntArray) =
        queries.also { nums.sort() }
            .map { q ->
                var acc = 0
                nums.takeWhile { (acc + it <= q).apply { acc += it } }.size
            }.toIntArray()
}
