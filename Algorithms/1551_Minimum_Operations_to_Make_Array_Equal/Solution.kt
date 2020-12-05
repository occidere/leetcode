/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-12-05
 */
class Solution {
    fun minOperations(n: Int): Int = generateSequence(1, { i -> i + 2 })
            .takeWhile { it < n }
            .map { n - it }
            .sum()
}