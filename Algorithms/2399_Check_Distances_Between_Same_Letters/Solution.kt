/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-11
 */
class Solution {
    fun checkDistances(s: String, distance: IntArray) = s.indices
        .map { s[it] to it }
        .groupBy({ it.first }) { it.second }
        .all { (c, xs) -> xs.zipWithNext().all { (i, j) -> j - i - 1 == distance[c - 'a'] } }
}
